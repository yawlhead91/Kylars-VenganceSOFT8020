package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.model.Inventory;
import ie.cit.repository.interfaces.InventoryInterface;
import ie.cit.rowmapper.InventoryRowMapper;

@Repository
public class InventoryRepo implements InventoryInterface{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Inventory get(int id) {
		String sql = "SELECT * FROM Inventory WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new InventoryRowMapper());
	}

	@Override
	public void save(Inventory ud) {
		if (ud.getId() != 0) {
			update(ud);
		} else {
			add(ud);
		}
	}

	private void add(Inventory ud) {
		String sql = "INSERT INTO Inventory (uId, weapon) VALUES (?, ?)";
		jdbcTemplate.update(sql,
				new  Object[] {ud.getuId(), ud.getWeapon()});
	}

	private void update(Inventory ud) {
		String sql = "UPDATE Inventory SET uId = ?, weapon = ? WHERE id = ?";
		jdbcTemplate.update(sql,
				new  Object[] {ud.getuId(), ud.getWeapon(), ud.getId()});
	}

	@Override
	public void remove(Inventory ud) {
		String sql = "DELETE From Inventory WHERE id = ?";
		jdbcTemplate.update(sql,
				new  Object[] {ud.getId()});
	}

	@Override
	public List<Inventory> findAll() {
		String sql = "SELECT * FROM Inventory";
		return jdbcTemplate.query(sql, new InventoryRowMapper());
	}

	@Override
	public List<Inventory> findUsersInventory(int id) {
		String sql = "SELECT * FROM Inventory WHERE uid = ?";
		return jdbcTemplate.query(sql, new  Object[] {id},  new InventoryRowMapper());
	}

	@Override
	public void saveEnchantment(Inventory item) {
		String sql = "UPDATE Inventory SET enchantment = ? WHERE id = ?";
		jdbcTemplate.update(sql,
				new  Object[] {item.getEnchantment(), item.getId()});
	}

}
