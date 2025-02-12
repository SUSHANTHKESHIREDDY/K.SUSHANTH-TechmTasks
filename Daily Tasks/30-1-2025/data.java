import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class data {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String[] parts = inputStr.split(";");
        String[] numbersStr = parts[0].split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numbersStr) {
            numbers.add(Integer.parseInt(numStr));
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int num : numbers) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }

        int primeCount = primeNumbers.size();

        if (primeCount >= 2) {
            Collections.sort(primeNumbers);
            int secondLargestPrime = primeNumbers.get(primeNumbers.size() - 2);
            int result = primeCount + secondLargestPrime;
            System.out.println(result);
        } 
    }
}