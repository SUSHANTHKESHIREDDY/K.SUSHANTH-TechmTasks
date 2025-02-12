package Autonomous;

public class AutonomousCar {
    private int cardid;
    private String brand;
    private int not;
    private int notp;
    
	private String env;
    private String grade;
    public  AutonomousCar(int carid,String brand,int not,String env) {
    	this.cardid=carid;
    	this.brand=brand;
    	this.env=env;
    	this.not=not;
    	
    }
    public int getNotp() {
		return notp;
	}
	public void setNotp(int notp) {
		this.notp = notp;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getNot() {
		return not;
	}
	public void setNot(int not) {
		this.not = not;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
    
}
