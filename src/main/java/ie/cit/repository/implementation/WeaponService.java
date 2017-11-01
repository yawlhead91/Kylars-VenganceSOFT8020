package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.model.Weapon;
import ie.cit.repository.interfaces.WeaponInterface;
import ie.cit.repository.interfaces.WeaponServiceInterface;

@Service
public class WeaponService implements WeaponServiceInterface{
	
	@Autowired
	WeaponInterface weaponsRepo;
	
	@Override
	public Weapon get(int id) {
		return weaponsRepo.get(id);
	}

	@Override
	public void save(Weapon w) {
		weaponsRepo.save(w);
	}

	@Override
	public void remove(Weapon w) {
		weaponsRepo.remove(w);
	}

	@Override
	public List<Weapon> findAll() {
		return weaponsRepo.findAll();
	}

}
