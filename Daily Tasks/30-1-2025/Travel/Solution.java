package Travel;
import Travel.TravelAgencies;
import java.util.Scanner;
public class Solution {
 
	public  static int  findAgencyWithHighestPackagePrice(TravelAgencies [] agency) {
		 int max=0;
		 for(TravelAgencies i:agency) {
			 if(i.price>max) {
				 max=i.price;
			 }
		 }
		 return max;
	}
	public static TravelAgencies agencyDetailsForGivenldAndType(TravelAgencies [] agency,int regno,String packagetype) {
		for(TravelAgencies i:agency) {
			if(i.filght &&(i.regno==regno && i.packagetype==packagetype)) {
				return i;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TravelAgencies [] ta=new TravelAgencies[2];
		for(int i=0;i<4;i++) {
			    int regno = sc.nextInt();
	            String agencyname = sc.next();
	            String packagetype = sc.next();
	            int price = sc.nextInt();
	            boolean flight=sc.nextBoolean();
	            ta[i]=new TravelAgencies(regno,agencyname,packagetype,price,flight);
		}
		int regNoToFind = sc.nextInt();
        String packageTypeToFind = sc.nextLine();
       int hs=findAgencyWithHighestPackagePrice(ta);
       TravelAgencies res=agencyDetailsForGivenldAndType(ta,regNoToFind,packageTypeToFind);
       System.out.println(hs);
       System.out.println(res);
       
	}
 }

