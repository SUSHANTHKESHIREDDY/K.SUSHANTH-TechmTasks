package Generics;
import java.util.*;
public class EvenOddGeneric {
      public static <T extends Number> List<Double> sumevenodd(List<T> num){
    	  if(num==null) {
    		  throw new IllegalArgumentException("Input list cannot be null.");
    	  }
    	  double esum=0;
    	  double osum=0;
    	  for(T i:num) {
    		  if(i==null) {
    			  continue;
    		  }
    		  double numb=i.doubleValue();
    		  if(numb%2==0) {
    			  esum=esum+numb;
    		  }
    		  else {
    			  osum =osum+ numb;
    		  }
    	  }
    	  List<Double> sums = new ArrayList<>();
          sums.add(esum);
          sums.add(osum);

          return sums;
      }
      public static void main(String[] args) {
    	  List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
          List<Double> doubleList = List.of(1.5, 2.0, 3.5, 4.0, 5.5, 6.0);
          List<Number> mixedList = List.of(1, 2.5, 3, 4.5, 5, 6.5);
          List<Double> intSums = sumevenodd(intList);
          System.out.println("Integer List: Even Sum = " + intSums.get(0) + ", Odd Sum = " + intSums.get(1));

          List<Double> doubleSums = sumevenodd(doubleList);
          System.out.println("Double List: Even Sum = " + doubleSums.get(0) + ", Odd Sum = " + doubleSums.get(1));

          List<Double> mixedSums = sumevenodd(mixedList);
          System.out.println("Mixed List: Even Sum = " + mixedSums.get(0) + ", Odd Sum = " + mixedSums.get(1)); 
      }
      
}
