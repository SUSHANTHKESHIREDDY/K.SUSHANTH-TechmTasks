package practice;
import java.util.Scanner;
public class odd {
public static void main(String [] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	String res="";
	for(int i=0;i<str.length();i++) {
		if(i%2!=0) {
			res=res+str.charAt(i);
		}
	}
	System.out.println(res);
}
}
