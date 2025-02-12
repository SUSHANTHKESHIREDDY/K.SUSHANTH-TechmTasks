package practice;

import java.util.Arrays;

public class copyofrange {
    public static void main(String [] args) {
    	int [] arr1= {1,2,3,4,5,6,7,8,9};
    	int [] arr2=Arrays.copyOfRange(arr1, 0, 2);
    	for(int i:arr2) {
    		System.out.println(i);
    	}
    }
}
