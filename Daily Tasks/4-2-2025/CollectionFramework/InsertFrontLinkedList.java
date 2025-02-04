package Collection;
import java.util.LinkedList;
import java.util.List;
public class InsertFrontLinkedList {
	 public static void main(String[] args) {
	        List<String> colors = new LinkedList<>(); // Good practice to use the List interface
	        colors.add("Red");
	        colors.add("Green");
	        colors.add("Blue");
	        String elementToInsert = "Purple";
	        colors.add(0,elementToInsert );
	        System.out.println(colors);
}
}