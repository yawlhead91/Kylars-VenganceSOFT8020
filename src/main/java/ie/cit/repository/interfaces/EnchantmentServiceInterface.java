package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.Enchantment;

public interface EnchantmentServiceInterface {
	Enchantment get(int id);
	void save(Enchantment ud);
	void remove(Enchantment ud);
	List<Enchantment> findAll();
}
