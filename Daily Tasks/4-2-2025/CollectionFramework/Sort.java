package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	 public static void main(String [] args) {
		 List<String> l=new ArrayList<>();
		  l.add("Blue");
		   l.add("red");
		   l.add("brown");
		   l.add("pink");
		   l.add("black");
		  l.add("white");
		  Collections.sort(l);
		  System.out.println(l);
}
}
