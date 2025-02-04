package Collection;

import java.util.ArrayList;
import java.util.List;

public class Search {
  
	   public static void main(String [] args) {
			 List<String> l=new ArrayList<>();
			  l.add("Blue");
			   l.add("red");
			   l.add("brown");
			   l.add("pink");
			   l.add("black");
			  l.add("white");
			  String tar="white";
			  boolean res=false;
			  for(int i=0;i<l.size();i++) {
				  if(l.get(i).equals(tar)) {
					  res=true;
					  break;
					  
				  }
			  }
			  if(res) {
				  System.out.println("found in Arraylist");
			  }
			  else {
				  System.out.println("Not found in Arraylist");
			  }
   }
}
