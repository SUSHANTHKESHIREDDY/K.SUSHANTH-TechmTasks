package loanapp;

public interface Loan {
  double getinterestrate();
  double calculateamount(double principle,int time);
  String loantype();
}
