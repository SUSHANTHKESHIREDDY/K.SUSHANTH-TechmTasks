package practice;
import java.util.*;
public class perfectsquare {
  public static void main(String [] args)
{
	  Scanner sc=new Scanner(System.in);
       long n=sc.nextLong();
       System.out.println(yes(n));
	  }
  public static boolean yes(long n) {
  if(n>0) {
	  long res=(long)Math.sqrt(n);
	  return ((res*res)==n);
  }
  
  return false;
}
}
