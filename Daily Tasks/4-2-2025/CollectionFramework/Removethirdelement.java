package Collection;

import java.util.ArrayList;
import java.util.List;

public class Removethirdelement {
	public static void main(String [] args) {
		 List<String> l=new ArrayList<>();
		  l.add("Blue");
		   l.add("red");
		   l.add("brown");
		   l.add("pink");
		   l.add("black");
		  l.add("white");
		  for(int i=0;i<l.size();i++) {
			  if(i==2) {
				  l.remove(i);
			  }
		  }
		  System.out.println(l);
}
}
