package Collection;
import java.util.LinkedList;
import java.util.List;
public class InsertEndLinkedList {
	 public static void main(String[] args) {
	        List<String> colors = new LinkedList<>(); // Good practice to use the List interface
	        colors.add("Red");
	        colors.add("Green");
	        colors.add("Blue");

	        System.out.println("Original LinkedList: " + colors);

	        String elementToInsert = "Purple";

	       
	        colors.add(elementToInsert); // Adds to the end by default

	        System.out.println( colors);

}
}