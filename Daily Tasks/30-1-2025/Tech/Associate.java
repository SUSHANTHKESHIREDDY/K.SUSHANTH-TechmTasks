package Tech;

public class Associate {
     int id;
     String name;
     String technology;
     int years;
     public Associate(int id,String name,String technology,int years) {
    	 this.id=id;
    	 this.name=name;
    	 this.technology=technology;
    	 this.years=years;
     }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
}
