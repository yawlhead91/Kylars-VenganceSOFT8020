package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.Inventory;

public interface InventoryServiceInterface {
	Inventory get(int id);
	void save(Inventory ud);
	void remove(Inventory ud);
	List<Inventory> findAll();
	List<Inventory> findUsersInventory(int id);
	void saveEnchantment(Inventory item);
}
