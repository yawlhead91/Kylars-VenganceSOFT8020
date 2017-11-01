package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.Weapon;

public interface WeaponServiceInterface {
	Weapon get(int id);
	void save(Weapon w);
	void remove(Weapon w);
	List<Weapon> findAll();
}
