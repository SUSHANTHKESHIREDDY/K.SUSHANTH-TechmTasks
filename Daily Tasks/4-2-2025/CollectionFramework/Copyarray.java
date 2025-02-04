package Collection;

import java.util.ArrayList;
import java.util.List;

public class Copyarray {
	 public static void main(String [] args) {
		 List<String> l=new ArrayList<>();
		  l.add("Blue");
		   l.add("red");
		   l.add("brown");
		   l.add("pink");
		   List<String> l2=new ArrayList<>(l);
		   System.out.println(l2);
	 }
}
