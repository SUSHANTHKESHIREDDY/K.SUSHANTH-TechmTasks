package Collection;

import java.util.LinkedList;

public class end {

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>(); // Using LinkedList directly (also correct)
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        System.out.println("Original LinkedList: " + myList);

        String elementToAppend = "Date";
        myList.add(elementToAppend);

        System.out.println("LinkedList after appending: " + myList);
    }
}