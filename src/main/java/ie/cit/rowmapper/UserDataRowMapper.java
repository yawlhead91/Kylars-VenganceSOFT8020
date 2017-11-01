package ie.cit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.model.UserData;

public class UserDataRowMapper implements RowMapper<UserData>{

	@Override
	public UserData mapRow(ResultSet rs, int index) throws SQLException {
		UserData ud = new UserData();
		ud.setId(rs.getInt("id"));
		ud.setFname(rs.getString("fname"));
		ud.setLname(rs.getString("lname"));
		ud.setKubit(rs.getInt("kubit"));
		ud.setLevel(rs.getInt("level"));
		return ud;
	}

}
