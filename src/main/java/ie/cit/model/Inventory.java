package ie.cit.model;

public class Inventory {
	private int id, uId, weapon, enchantment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public int getEnchantment() {
		return enchantment;
	}

	public void setEnchantment(int enchantment) {
		this.enchantment = enchantment;
	}
	
	@Override
	public String toString() {
		return "Id:" + id + " ____ uid: " + uId + "_____ weapon:" + weapon + "____ enchantment: " + enchantment;
	}
}
