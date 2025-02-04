package Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
public class IterateLinkedListFromPosition {
	 public static void main(String[] args) {
	        List<String> colors = new LinkedList<>();
	        colors.add("Red");
	        colors.add("Green");
	        colors.add("Blue");
	        colors.add("Yellow");
	        colors.add("Orange");
	        int start=2;
	        ListIterator<String> listIterator = colors.listIterator(start); // Start at the specified position

            while (listIterator.hasNext()) {
                System.out.println(listIterator.next());
            }
}
}
