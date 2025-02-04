package Generics;

import java.util.Arrays;
import java.util.Objects;

public class ArrayComparison {
        public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        	if(arr1==null || arr2==null ) {
        		return false;
        	}
        	
        	for(int i=0;i<arr1.length;i++) {
        		if(!Objects.equals(arr1[i], arr2[i])) {
        			return false;
        		}
        	}
        	return true;
        }
        public static boolean compareArrays(int[] arr1, int[] arr2) {
            if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
                return false;
            }
            return Arrays.equals(arr1, arr2);
        }
        public static boolean compareArrays(double[] arr1, double[] arr2) {
            if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
                return false;
            }
            return Arrays.equals(arr1, arr2);
        }
        public static boolean compareArrays(char[] arr1, char[] arr2) {
            if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
                return false;
            }
            return Arrays.equals(arr1, arr2);
        }
  public static void main(String [] args) {
	  int[] intArr1 = {1, 2, 3};
      int[] intArr2 = {1, 2, 3};
      Integer[] arr1= {1,2,3};
      Integer []arr2= {4,5,6};
      String[] strArr1 = {"apple", "banana", "cherry"};
      String[] strArr2 = {"apple", "banana", "cherry"};
      System.out.println( compareArrays(intArr1, intArr2));
      System.out.println( compareArrays(arr1, arr2));
      System.out.println( compareArrays(strArr1, strArr2));
  }
}

