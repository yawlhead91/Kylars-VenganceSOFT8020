package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.model.UserData;
import ie.cit.repository.interfaces.UserDataInterface;
import ie.cit.rowmapper.UserDataRowMapper;

@Repository
public class UserDataRepo implements UserDataInterface{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public UserData get(int id) {
		String sql = "SELECT * FROM Users WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserDataRowMapper());
	}

	@Override
	public void save(UserData ud) {
		if (ud.getId() != 0) {
			update(ud);
		} else {
			add(ud);
		}
	}

	private void add(UserData ud) {
		String sql = "INSERT INTO Users (fname, lname) VALUES (?,?)";
		jdbcTemplate.update(sql, 
				new Object[] { ud.getFname(), ud.getLname()} );
	}

	private void update(UserData ud) {
		String sql = "UPDATE Users SET fname = ?, lname = ?, kubit = ?"
				+ ", level = ?";
		jdbcTemplate.update(sql, new Object[] {ud.getFname(), ud.getLname(),
				ud.getKubit(), ud.getLevel()} );
	}

	@Override
	public void remove(UserData ud) {
		String sql = "DELETE Users WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { ud.getId() } );
	}

	@Override
	public List<UserData> findAll() {
		String sql = "SELECT * FROM Users";
		return jdbcTemplate.query(sql, new UserDataRowMapper());
	}

}
