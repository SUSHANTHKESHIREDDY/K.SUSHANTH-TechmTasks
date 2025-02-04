package Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
public class ReverseLinkedListIteration {
	public static void main(String[] args) {
        List<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        ListIterator<String> listIterator = colors.listIterator(colors.size()); 

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
}
}
