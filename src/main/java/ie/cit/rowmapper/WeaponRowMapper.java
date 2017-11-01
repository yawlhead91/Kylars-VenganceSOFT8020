package ie.cit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.model.Weapon;

public class WeaponRowMapper implements RowMapper<Weapon>{

	@Override
	public Weapon mapRow(ResultSet rs, int index) throws SQLException {
		Weapon w = new Weapon();
		w.setId(rs.getInt("id"));
		w.setName(rs.getString("name"));
		w.setDamage(rs.getInt("damage"));
		w.setProtention(rs.getInt("protection"));
		w.setRanged(rs.getInt("ranged"));
		w.setwType(rs.getString("wtype"));
		w.setLevel(rs.getInt("level"));
		w.setCost(rs.getInt("cost"));
		return w;
	}

}
