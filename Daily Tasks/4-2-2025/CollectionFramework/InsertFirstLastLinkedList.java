package Collection;
import java.util.LinkedList;
import java.util.List;
public class InsertFirstLastLinkedList {
	public static void main(String[] args) {
        List<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        String elementToInsertFirst = "Purple";
        String elementToInsertLast = "Yellow";
        colors.add(0, elementToInsertFirst);
        colors.add(elementToInsertLast);
        System.out.println(colors);
}
}