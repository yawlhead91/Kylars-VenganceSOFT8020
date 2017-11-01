package ie.cit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.model.Inventory;

public class InventoryRowMapper implements RowMapper<Inventory>{

	@Override
	public Inventory mapRow(ResultSet rs, int index) throws SQLException {
		Inventory i = new Inventory();
		i.setId(rs.getInt("id"));
		i.setuId(rs.getInt("uId"));
		i.setWeapon(rs.getInt("weapon"));
		i.setEnchantment(rs.getInt("enchantment"));
		return i;
	}

}
