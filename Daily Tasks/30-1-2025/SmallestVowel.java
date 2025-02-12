package practice;
import java.util.Scanner;
public class SmallestVowel {
  public static void main(String [] args) {
	  Scanner sc=new Scanner(System.in);
	  String str=sc.next();
	 
	  System.out.println(smallest(str));
  }
  public static char smallest(String str) {
	  char sm='\0';
	  for(int i=0;i<str.length();i++) {
	  if(isvowel(str.charAt(i))) {
		  if(sm=='\0' || str.charAt(i)<sm) {
			  sm=str.charAt(i);
		  }
	  }
	  
  }
	  return sm;
  }
  public static  boolean isvowel(char c) {
	  if(c=='a'|| c=='e'||c=='i'||c=='o'||c=='u') {
		  return true;
	  }
	  return false;
  }
}
