package ie.cit;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ie.cit.model.Enchantment;
import ie.cit.model.Inventory;
import ie.cit.model.UserData;
import ie.cit.model.Weapon;
import ie.cit.repository.interfaces.EnchantmentServiceInterface;
import ie.cit.repository.interfaces.InventoryServiceInterface;
import ie.cit.repository.interfaces.UserDataServiceInterface;
import ie.cit.repository.interfaces.WeaponServiceInterface;

@SpringBootApplication
public class KylarsVengeanceApplication implements CommandLineRunner {
	
	private Scanner in;
	private UserData user;
	private List<Weapon> weaponslist;
	private List<Enchantment> enchantmentslist;
	private List<Inventory> inventory;
	
	@Autowired
	UserDataServiceInterface uds;
	
	@Autowired
	WeaponServiceInterface wds;
	
	@Autowired
	EnchantmentServiceInterface eds;
	
	@Autowired
	InventoryServiceInterface ids;
	
	public static void main(String[] args) {
		SpringApplication.run(KylarsVengeanceApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception  {
		
		in = new Scanner(System.in);
		weaponslist = wds.findAll();
		enchantmentslist = eds.findAll();
		
		System.out.println("Kylars Vengeance");
		usermenu();
		gatherInventory(user);
		mainmenu();
	}
	
	private void usermenu() {
		List<UserData> ud = uds.findAll();
		System.out.println("User Menu");
		UserData u = null;
		do {
			for(UserData d : ud) {
				System.out.format("ID: %d ) %s\n", d.getId(), d.getName());
			}
			System.out.println("Please enter player id: ");
			String id = in.nextLine();
			u = ud.stream().filter(c -> Integer.toString(c.getId()).equals(id)).findFirst().orElse(null);
		}while(u == null);
		
		System.out.format("Logged in %s\n\n\n", u.getName());
		this.user = u;
	}
	
	private void gatherInventory(UserData u) {
		inventory = ids.findUsersInventory(u.getId());
	}
	
	private void mainmenu() {
		boolean exit = false;
		do {
			System.out.println("#Main Menu#");
			System.out.println("1) New round");
			System.out.println("2) Buy new equipment");
			System.out.println("3) Sell equipment");
			System.out.println("4) Upgrade equipment");
			System.out.println("5) Enchant item");
			System.out.println("6) Exit");
			System.out.println("Please enter choice number");
			int c = Integer.parseInt(in.nextLine());
			
			switch(c) {
			case 1: nextround(); break;
			case 2: buyequipment(); break;
			case 3: sellequipment(); break;
			case 4: upgradeequipment(); break;
			case 5: enchantequipment(); break;
			case 6: exit = true; break;
			}
		}while(!exit);
		
		uds.save(user);
	}
	
	// Here we enchant the weapons
	private void enchantequipment() {
		boolean fin = false;
		do {
			if(inventory.size() == 0) {
				System.out.println("You have no items to upgrade");
				return;
			}
			
			System.out.format("Kubits: %d\n", user.getKubit());
			// Print users inventory
			for(Inventory i : inventory) {
				Weapon w = wds.get(i.getWeapon());
				int gh = w.getLevel();
				System.out.format("ID: %d ) %s | DMG: %d | PTR: %d | RNG: %d | LVL: %d | ENC: %d | COST: %d \n", 
						i.getId(), w.getName(), w.getDamage(),
						w.getProtention(), w.getRanged(), w.getLevel(), i.getEnchantment(), w.getCost());
			}
			
		
			System.out.println("Please enter choice by id number");
			String ch = in.nextLine();
			
			// Retrieve the item chosen
			Inventory item = inventory.stream().filter(inv ->  Integer.toString(inv.getId()).equals(ch)).findFirst().orElse(null);
			if(item != null) {
				// GET weapons details so we can then retrieve only the enchantment's that are 
				// compatible with the type of weapon
				Weapon w = wds.get(item.getWeapon());
				List<Enchantment> e = enchantmentslist.stream().filter(ei -> ei.geteType().equals(w.getwType())).collect(Collectors.toList());
				for(Enchantment en: e) {
					System.out.format("ID %d ) %s | Bonus Damge: %s | Bonus Protection %s\n", en.getId(), en.getName(), en.getBonusdmg(), en.getBonusprt());
				}
				
				System.out.println("Please enter choice by id number");
				String ch2 = in.nextLine();
				
				// Get the enchantment details and save and its id to the inventory enchantment foreign key 
				Enchantment echoice =  enchantmentslist.stream().filter(enh -> Integer.toString(enh.getId()).equals(ch2)).findFirst().orElse(null);
				if(echoice != null) {
					if(echoice.getCost() > user.getKubit()) {
						System.out.println("You do not have enough kubic to purchase this item");
						continue;
					}
					
					user.setKubit(user.getKubit() - echoice.getCost());
					
					item.setEnchantment(echoice.getId());
					ids.saveEnchantment(item);
					
					System.out.format("Enchantment purchased -%d Kubit\n", echoice.getCost());
				}else {
					System.out.println("Id not found, canceled");
				}
				
			}else {
				System.out.println("This item is at max level");
			}
			
			// Prompt user to exit to stay
			System.out.println("Would you like to upgrade again - Y(yes) or N(no)");
			String c = in.nextLine();
			if(c.equals("N")) {
				fin = true;
			}
		}while(!fin);
	}

	private void upgradeequipment() {
		boolean fin = false;
		do {
			if(inventory.size() == 0) {
				System.out.println("You have no items to upgrade");
				return;
			}
			
			System.out.format("Kubits: %d\n", user.getKubit());
			// Print inventory 
			for(Inventory i : inventory) {
				Weapon w = wds.get(i.getWeapon());
				int gh = w.getLevel();
				System.out.format("ID: %d ) %s | DMG: %d | PTR: %d | RNG: %d | LVL: %d | ENC: %d | COST: %d \n", 
						i.getId(), w.getName(), w.getDamage(),
						w.getProtention(), w.getRanged(), w.getLevel(), i.getEnchantment(), w.getCost());
			}
			
			System.out.println("Please enter choice by id number");
			String ch = in.nextLine();
			// Get user choice of inventory
			Inventory item = inventory.stream().filter(inv ->  Integer.toString(inv.getId()).equals(ch)).findFirst().orElse(null);
			if(item != null) {
				// Ensure user has enough kubit
				Weapon w = wds.get(item.getWeapon());
				if(w.getCost() > user.getKubit()) {
					System.out.println("You do not have enough kubic to updgrade this item");
					continue;
				}
				// Ensure weapon level is than the maximum 
				if(w.getLevel() < 3) {
					Weapon u = weaponslist.stream().filter(wr -> wr.getName().equals(w.getName()))
							.filter(wr -> wr.getLevel() == w.getLevel() + 1)
							.findFirst().orElse(null);
					
					// Charge user for purchase
					user.setKubit(user.getKubit() - u.getCost());
					
					item.setWeapon(u.getId());
					ids.save(item);
					gatherInventory(user);
					
					System.out.format("Purchase complete: -%d Kubit\n", u.getCost());
					// Print upgraded weapon details
					System.out.format("Upgraded %s | DMG: %d | PTR: %d | RNG: %d | LVL: %d | ENC: %d | COST: %d \n", 
							u.getName(), u.getDamage(),
							u.getProtention(), u.getRanged(), u.getLevel(), item.getEnchantment(), u.getCost());

				}else {
					System.out.println("This item is at max level");
				}
				
			}else {
				System.out.println("Id not found");
			}
			
			System.out.println("Would you like to upgrade again - Y(yes) or N(no)");
			String c = in.nextLine();
			if(c.equals("N")) {
				fin = true;
			}
			
		}while(!fin);
	}

	private void sellequipment() {
		boolean fin = false;
		do {
			if(inventory.size() == 0) {
				System.out.println("You have no items to sell");
				return;
			}
			
			System.out.format("Kubits: %d\n", user.getKubit());
			
			for(Inventory i : inventory) {
				Weapon w = wds.get(i.getWeapon());
				int gh = w.getLevel();
				System.out.format("ID: %d ) %s | DMG: %d | PTR: %d | RNG: %d | LVL: %d | ENC: %d | COST: %d \n", 
						i.getId(), w.getName(), w.getDamage(),
						w.getProtention(), w.getRanged(), w.getLevel(), i.getEnchantment(), w.getCost());
			}
			
			System.out.println("Please enter choice by id number");
			String ch = in.nextLine();
			
			Inventory item = inventory.stream().filter(inv ->  Integer.toString(inv.getId()).equals(ch)).findFirst().orElse(null);
			
			if(item != null) {
				Weapon w = wds.get(item.getWeapon());
				user.setKubit(user.getKubit() + w.getCost());
				ids.remove(item);
				gatherInventory(user);
				System.out.format("Items sold +%d Kubic\n", w.getCost());
			}else {
				System.out.println("Id not found");
			}
			
			System.out.println("Would you like to sell again - Y(yes) or N(no)");
			String c = in.nextLine();
			if(c.equals("N")) {
				fin = true;
			}
		}while(!fin);
		
	}

	private void buyequipment() {
		boolean fin = false;
		do {
			if(inventory.size() == 4) {
				System.out.println("You can not buy at this time, please sell some of your inventory");
				return;
			}
			
			System.out.format("Kubits: %d", user.getKubit());
			
			List<Weapon> wl = weaponslist.stream().filter(w -> w.getLevel() == 1).collect(Collectors.toList());
			for(Weapon w : wl) {
				System.out.format("\nID: %d ) %s | DMG: %d | PTR: %d | RNG: %d | COST: %d", 
						w.getId(), w.getName(), w.getDamage(),
						w.getProtention(), w.getRanged(), w.getCost());
				
			}
			
			System.out.println("Please enter choice by id number");
			String ch = in.nextLine();
			Weapon wc = weaponslist.stream().filter(w -> Integer.toString(w.getId()).equals(ch)).findFirst().orElse(null);
			
			if(wc != null) {
				if(wc.getCost() > user.getKubit()) {
					System.out.println("You do not have enough kubic to buy this item");
					continue;
				}
				user.setKubit(user.getKubit() - wc.getCost());
				Inventory ni = new Inventory();
				ni.setuId(user.getId());
				ni.setWeapon(wc.getId());
				ids.save(ni);
				gatherInventory(user);
			}else {
				System.out.println("Id not found");
			}
			
			System.out.println("Would you like to buy another item - Y(yes) or N(no)");
			String c = in.nextLine();
			if(c.equals("N")) {
				fin = true;
			}
		}while(!fin);
		
	}

	private void nextround() {
		// Game imp here
		System.out.println("====== ================ =========");
		System.out.println("====== Rounds finnished =========");
		System.out.println("====== ================ =========");
		user.setKubit(user.getKubit() + 100);
		uds.save(user);
	}
}
