package Collection;

import java.util.ArrayList;
import java.util.List;

public class Specificindex {
	public static void main(String [] args) {
		  List<String> l=new ArrayList<>();
		  l.add("Blue");
		   l.add("red");
		   l.add("brown");
		   l.add("pink");
		   l.add("black");
		  l.add(0,"white");
		  int tar=2;
		  for(int i=0;i<l.size();i++) {
			  if(i==2) {
				  System.out.println(l.get(2));
			  }
		  }
}
}