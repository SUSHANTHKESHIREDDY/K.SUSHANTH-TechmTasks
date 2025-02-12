package practice;

public class copyofarray {
	public static void main(String [] args) {
int sa[]= {1,2,3,4,5,6,7,8,9};
int n=(sa.length)/2 +1;
int na[]=new int [n];
for(int i=0,j=0;i<sa.length;i+=2,j++) {
	System.arraycopy(sa, i, na, j, 1);
}
for(int k:na) {
	System.out.println(k+" ");
}
}
}