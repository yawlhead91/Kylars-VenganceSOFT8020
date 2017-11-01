package ie.cit.model;

public class Weapon {
	private int id, damage, protention, ranged, level, cost;
	private String name, wType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getProtention() {
		return protention;
	}
	public void setProtention(int protention) {
		this.protention = protention;
	}
	public int getRanged() {
		return ranged;
	}
	public void setRanged(int ranged) {
		this.ranged = ranged;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getwType() {
		return wType;
	}
	public void setwType(String wType) {
		this.wType = wType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
