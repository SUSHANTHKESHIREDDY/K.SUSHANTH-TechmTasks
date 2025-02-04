package Generics;
import java.util.*;
public class Reverselist {
        public static <T> List<T> reverse(List<T> l){
        	List<T> res=new ArrayList<>(l);
            Collections.reverse(res);
            return res;
        }
        public static void main(String [] args) {
        	List<Integer> intList = List.of(1, 2, 3, 2, 4, 5);
        	System.out.println(reverse(intList));
        }
}
