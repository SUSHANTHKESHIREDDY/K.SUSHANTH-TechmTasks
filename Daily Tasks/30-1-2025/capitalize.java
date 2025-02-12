package practice;
import java.util.Scanner;
public class capitalize {
public static void main(String [] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	String res="";
	for(int i=0;i<str.length();i++) {
		if(i%2!=0) {
			res=res+str.charAt(i);
		}
		else {
		res=res+Character.toUpperCase(str.charAt(i));
	}
	}
	System.out.println(res);
}
}
