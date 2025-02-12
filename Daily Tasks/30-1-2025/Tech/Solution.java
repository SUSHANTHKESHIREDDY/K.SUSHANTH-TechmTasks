package Tech;
import java.util.*;
import Tech.Associate;
public class Solution {
   public static Associate[] associatesForGivenTechnology(Associate [] ass,String searchtech) {
	   List<Associate> list=new ArrayList<>();
	   for(Associate asso:ass) {
		   if(asso.getTechnology().equals(searchtech) && asso.getYears() %5==0) {
			   list.add(asso);
		   }
	   }
	   return list.toArray(new Associate[0]);
   }
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Associate[] associates = new Associate[5];

       for (int i = 0; i < 5; i++) {
           int id = scanner.nextInt();
           scanner.nextLine(); // Consume newline
           String name = scanner.nextLine();
           String technology = scanner.nextLine();
           int experienceInYears = scanner.nextInt();
           scanner.nextLine(); // Consume newline
           associates[i] = new Associate(id, name, technology, experienceInYears);
       }
       String searchTechnology = scanner.nextLine();
       Associate[] filteredAssociates = Solution.associatesForGivenTechnology(associates, searchTechnology);

       for (Associate associate : filteredAssociates) {
           System.out.println(associate.getId());
       }
   
   }
   
}