package Collection;

import java.util.ArrayList;
import java.util.List;

public class InsetAtBeg {
	public static void main(String [] args) {
		  List<String> l=new ArrayList<>();
		  l.add("Blue");
		   l.add("red");
		   l.add("brown");
		   l.add("pink");
		   l.add("black");
		  l.add(0,"white");
		  System.out.println(l);
	}
}
