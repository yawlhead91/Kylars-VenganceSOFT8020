package ie.cit.repository.interfaces;

import java.util.List;
import ie.cit.model.Weapon;

public interface WeaponInterface {
	public Weapon get(int id);
	public void save(Weapon w);
	public void remove(Weapon w);
	public List<Weapon> findAll();
}
