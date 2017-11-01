package ie.cit.model;

public class UserData {
	private int id, kubit, level;
	private String fname, lname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKubit() {
		return kubit;
	}
	public void setKubit(int kubit) {
		this.kubit = kubit;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id : " + id + "\nName: " + fname + 
				" " + lname + "\nKubit: " + kubit + "\nlevel: " + level;
	}
	public String getName() {
		return this.fname + " " + this.lname;
	}
	
}
