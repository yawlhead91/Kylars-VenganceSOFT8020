package ie.cit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.model.Enchantment;

public class EnchantmentRowMapper implements RowMapper<Enchantment>{
	@Override
	public Enchantment mapRow(ResultSet rs, int index) throws SQLException {
		Enchantment e = new Enchantment();
		e.setId(rs.getInt("id"));
		e.seteType(rs.getString("etype"));
		e.setName(rs.getString("name"));
		e.setBonusdmg(rs.getInt("bonusdmg"));
		e.setBonusprt(rs.getInt("bonusprt"));
		e.setCost(rs.getInt("cost"));
		return e;
	}
}
