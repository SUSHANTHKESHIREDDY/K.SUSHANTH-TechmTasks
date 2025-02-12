package practice;
import java.util.*;
public class unique {
 public static void main (String [] args) {
	 Scanner sc=new Scanner(System.in);
	 String str=sc.nextLine();
	 Set<Character> set=new HashSet<>();
	 for(int i=0;i<str.length();i++) {
		 set.add(str.charAt(i));
	 }
	 String res="";
	 for(char i:set) {
		 res=res+i;
	 }
	 System.out.println(res);
 }
}
