package ie.cit.model;

public class Enchantment {
	private int id, bonusdmg, bonusprt, cost;
	private String name, eType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBonusdmg() {
		return bonusdmg;
	}
	public void setBonusdmg(int bonusdmg) {
		this.bonusdmg = bonusdmg;
	}
	public int getBonusprt() {
		return bonusprt;
	}
	public void setBonusprt(int bonusprt) {
		this.bonusprt = bonusprt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteType() {
		return eType;
	}
	public void seteType(String eType) {
		this.eType = eType;
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
