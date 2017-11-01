package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.model.Enchantment;
import ie.cit.repository.interfaces.EnchantmentInterface;
import ie.cit.repository.interfaces.EnchantmentServiceInterface;

@Service
public class EnchantmentService implements EnchantmentServiceInterface {
	
	@Autowired
	EnchantmentInterface EnchantmentRepo;

	@Override
	public Enchantment get(int id) {
		return EnchantmentRepo.get(id);
	}

	@Override
	public void save(Enchantment ed) {
		EnchantmentRepo.save(ed);
	}

	@Override
	public void remove(Enchantment ed) {
		EnchantmentRepo.remove(ed);
	}

	@Override
	public List<Enchantment> findAll() {
		return EnchantmentRepo.findAll();
	}

}
