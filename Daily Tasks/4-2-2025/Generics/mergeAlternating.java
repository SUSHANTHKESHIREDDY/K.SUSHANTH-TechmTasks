package Generics;
import java.util.*;
public class mergeAlternating {
    public static <T> List<T> merge(List<T> l1,List<T> l2){
    	List<T> res=new ArrayList<>();
    	int i=0;
    	int j=0;
    	while(i<l1.size() || j<l2.size()) {
    		if(i<l1.size()) {
    			res.add(l1.get(i));
    			i++;
    		}
    		if(j<l2.size()) {
    			res.add(l2.get(j));
    			j++;
    		}
    	}
    	return res;
    }
    public static void main(String [] args) {
    	List<Integer> l1=List.of(1,2,3,4,5,6);
    	List<Integer> l2=List.of(7,8,9,4,5,6);
    	System.out.println(merge(l1,l2));
    }
}
