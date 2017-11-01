package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.Inventory;;

public interface InventoryInterface {
	public Inventory get(int id);
	public void save(Inventory ud);
	public void remove(Inventory ud);
	public List<Inventory> findAll();
	public List<Inventory> findUsersInventory(int id);
	public void saveEnchantment(Inventory item);
}
