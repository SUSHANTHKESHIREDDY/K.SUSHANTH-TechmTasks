package loanapp;

public class vehicleloan implements Loan{
  private double interestrate;
  public vehicleloan() {
	  this.interestrate=8.0;
  }
  public vehicleloan(double interestrate) {
	  this.interestrate=interestrate;
  }
  public void setInterestrate(double interestrate) { // Corrected setter method name and signature
      this.interestrate = interestrate;
  }
public double getinterestrate() {
	return interestrate;
}
public double calculateamount(double principle,int time) {
	return principle * (1 + (interestrate / 100) * time);
}
public String loantype() {
    return "vehicle Loan";		
}
}
