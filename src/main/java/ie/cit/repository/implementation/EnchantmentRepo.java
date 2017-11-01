package ie.cit.repository.implementation;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.model.Enchantment;
import ie.cit.repository.interfaces.EnchantmentInterface;
import ie.cit.rowmapper.EnchantmentRowMapper;
import ie.cit.rowmapper.UserDataRowMapper;

@Repository
public class EnchantmentRepo implements EnchantmentInterface{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Enchantment get(int id) {
		String sql = "SELECT * FROM Enchantments WHERE id = ?";	
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new EnchantmentRowMapper());
	}

	@Override
	public void save(Enchantment ed) {
		if (ed.getId() != 0) {
			update(ed);
		} else {
			add(ed);
		}
	}

	private void add(Enchantment ed) {
		String sql  = "INSERT INTO Enchantments VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new  Object[] {nullValue(), ed.getName(), 
						ed.geteType(), ed.getBonusdmg(), ed.getBonusprt()});
	}

	private void update(Enchantment ed) {
		String sql = "UPDATE Enchantments SET name = ?, etype = ?, bonusdmg = ?, bonusprt = ?";
		jdbcTemplate.update(sql,
				new  Object[] {ed.getName(), ed.geteType(), 
						ed.getBonusdmg(), ed.getBonusprt()});
	}

	@Override
	public void remove(Enchantment ed) {
		String sql = "DELETE FROM Enchantments WHERE id = ?";
		jdbcTemplate.update(sql,
				new  Object[] {ed.getId()});
	}

	@Override
	public List<Enchantment> findAll() {
		String sql = "SELECT * FROM Enchantments";
		return jdbcTemplate.query(sql, new EnchantmentRowMapper());
	}

}
