package Collection;
import java.util.LinkedList;
import java.util.List;
public class InsertAtPositionLinkedList {
	public static void main(String[] args) {
        List<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        String elementToInsert = "Purple";
        int positionToInsert = 2;
        colors.add(positionToInsert, elementToInsert);
        System.out.println(colors);
}
}
