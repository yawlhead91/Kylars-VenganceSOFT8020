package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.Enchantment;

public interface EnchantmentInterface {
	public Enchantment get(int id);
	public void save(Enchantment ud);
	public void remove(Enchantment ud);
	public List<Enchantment> findAll();
}
