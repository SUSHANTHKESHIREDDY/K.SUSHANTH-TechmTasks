package Collection;
import java.util.LinkedList;
import java.util.List;
public class FirstLastOccurrence {
	 public static void main(String[] args) {
	        List<String> colors = new LinkedList<>();
	        colors.add("Red");
	        colors.add("Green");
	        colors.add("Blue");
	        colors.add("Red"); 
	        colors.add("Yellow");
	        colors.add("Green"); 
	        colors.add("Orange");
	        String targetElement = "Red";
	        int firstIndex = colors.indexOf(targetElement);
	        int lastIndex = colors.lastIndexOf(targetElement);
	        System.out.println(firstIndex +" "+ lastIndex);
}
}