package Autonomous;
import Autonomous.AutonomousCar;
public class Solution {
public static int findTestPassedByEnv(AutonomousCar [] auto,String env) {
	int sum=0;
	for(AutonomousCar i:auto) {
		if(i.getEnv()==env) {
			sum=sum+i.getNot();
		}
	}
	return sum;
}
public static AutonomousCar updateCarGrade(String brand,AutonomousCar [] auto) {
	for(AutonomousCar i:auto) {
		if
	int rating=
	}
}
}
