package loanapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
  public static void main(String [] args) {
	  ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	  Loan housingloan=context.getBean("housing",Loan.class);
	  String loantype=housingloan.loantype();
	  double amt=housingloan.calculateamount(10000, 10);
	  System.out.println(loantype);
	  System.out.println(amt);
	  System.out.println(housingloan.getinterestrate());
	  
	  
	  
	  Loan vehicleloan=context.getBean("vehicle",Loan.class);
	  String loantype1=vehicleloan.loantype();
	  double amt1=vehicleloan.calculateamount(10000, 10);
	  System.out.println(loantype1);
	  System.out.println(amt1);
	  System.out.println(vehicleloan.getinterestrate());
  }
}
