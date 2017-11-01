package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.model.Inventory;
import ie.cit.repository.interfaces.InventoryInterface;
import ie.cit.repository.interfaces.InventoryServiceInterface;

@Service
public class InventoryService implements InventoryServiceInterface {
	
	@Autowired
	InventoryInterface inventoryRepo;
	
	@Override
	public Inventory get(int id) {
		return inventoryRepo.get(id);
	}

	@Override
	public void save(Inventory ud) {
		inventoryRepo.save(ud);
	}

	@Override
	public void remove(Inventory ud) {
		inventoryRepo.remove(ud);
	}

	@Override
	public List<Inventory> findAll() {
		return inventoryRepo.findAll();
	}
	
	public List<Inventory> findUsersInventory(int id) {
		return inventoryRepo.findUsersInventory(id);
	}

	@Override
	public void saveEnchantment(Inventory item) {
		inventoryRepo.saveEnchantment(item);
	}

}
