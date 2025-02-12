package sim;

public class Sim {
int simid;
String customername;
double balance;
double rps;
String circle;
public Sim(int simid,String customername,double balance,double rps,String circle) {
	this.simid=simid;
	this.customername=customername;
	this.balance=balance;
	this.rps=rps;
	this.circle=circle;
}
public int getSimid() {
	return simid;
}
public void setSimid(int simid) {
	this.simid = simid;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getRps() {
	return rps;
}
public void setRps(double rps) {
	this.rps = rps;
}
public String getCircle() {
	return circle;
}
public void setCircle(String circle) {
	this.circle = circle;
}

}
