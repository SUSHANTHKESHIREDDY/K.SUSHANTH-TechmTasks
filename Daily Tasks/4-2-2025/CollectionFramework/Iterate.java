package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Iterate {
  public static void main(String [] args) {
	  List<String> l=new ArrayList<>();
	   l.add("Blue");
	   l.add("red");
	   l.add("brown");
	   l.add("pink");
	   l.add("black");
	   Iterator<String> i=l.iterator();
	   while(i.hasNext()) {
		   String c=i.next();
		   System.out.println(c);
	   }
	   
  }
}
