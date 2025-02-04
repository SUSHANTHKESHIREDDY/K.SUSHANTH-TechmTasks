package Collection;

import java.util.ArrayList;
import java.util.List;

public class UpdateElement {
	public static void main(String [] args) {
	 List<String> l=new ArrayList<>();
	  l.add("Blue");
	   l.add("red");
	   l.add("brown");
	   l.add("pink");
	   l.add("black");
	  l.add("white");
	  String tar="black";
	 for(int i=0;i<l.size();i++) {
		 if(l.get(i).equals(tar)) {
			 l.set(i, "lavender");
			 break;
		 }
	 }
	  System.out.println(l);
}
}
