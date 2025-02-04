package Generics;
import java.util.*;
public class GenricSearch {
    public static <T> int search(List<T> l,T tar) {
    	if(l==null|| tar==null) {
    		throw new IllegalArgumentException("List and target cannot be null.");
    	}
    	for(int i=0;i<l.size();i++) {
    		T ele=l.get(i);
    		if(Objects.equals(ele, tar)) {
    			return i;
    		}
    	}
    	return -1;
    }
    public static void main(String [] args) {
    	 List<String> stringList = List.of("apple", "banana", "cherry", "banana");
         String targetString1 = "banana";
         List<Integer> intList = List.of(1, 2, 3, 2, 4, 5);
         Integer targetInt1 = 2;
         List<Double> doubleList = List.of(1.0, 2.5, 3.0, 2.5);
         Double targetDouble1 = 2.5;
         System.out.println("Index of '" + targetString1 + "': " + search(stringList, targetString1));
         System.out.println("Index of " + targetInt1 + ": " + search(intList, targetInt1));
         System.out.println("\nDouble List:");
         System.out.println("Index of " + targetDouble1 + ": " + search(doubleList, targetDouble1)); 
         }
}
