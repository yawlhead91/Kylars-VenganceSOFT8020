package ie.cit.repository.implementation;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.model.Weapon;
import ie.cit.repository.interfaces.WeaponInterface;
import ie.cit.rowmapper.WeaponRowMapper;

@Repository
public class WeaponRepo implements WeaponInterface{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Weapon get(int id) {
		String sql = "SELECT * FROM Weapons WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new WeaponRowMapper());
	}

	@Override
	public void save(Weapon w) {
		if(w.getId() != 0) {
			update(w);
		}else {
			add(w);
		}
	}

	private void add(Weapon w) {
		String sql = "INSERT INTO Weapons VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				new Object[] { nullValue(), w.getName(), w.getwType(), 
						w.getDamage(), w.getProtention(), w.getRanged(), w.getLevel()});
	}

	private void update(Weapon w) {
		String sql = "UPDATE Weapons SET name = ?, wtype = ?, damage = ?, "
				+ "protection = ?, ranged = ?, level = ?";
		jdbcTemplate.update(sql, new Object[] { w.getName(), w.getwType(),
						w.getDamage(), w.getProtention(), w.getRanged(), w.getLevel()});
	}

	@Override
	public void remove(Weapon w) {
		String sql = "DELETE Weapons WHERE id =  ?";
		jdbcTemplate.update(sql, new Object[] { w.getId() } );
	}

	@Override
	public List<Weapon> findAll() {
		String sql = "SELECT * FROM Weapons";
		return jdbcTemplate.query(sql, new WeaponRowMapper());
	}

}
