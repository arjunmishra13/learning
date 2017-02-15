package misc.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NumbersWithNonRepeatedDigits {

	public static int numberOfNumbersWithNonRepeatedDigits(int maxRepeatedDigits, int radix) {
		int start = (int)Math.pow(10.0, radix - 1);
		int end = (int)Math.pow(10.0, radix);
		int totalNumberOfNumbers = end - start;
		for(int num = start; num < end; num++) {
			if(numberHasRepeatedDigits(num, maxRepeatedDigits)) { 
				totalNumberOfNumbers--;
			} 
		}
		return totalNumberOfNumbers;
	}
	
	private static boolean numberHasRepeatedDigits(int num, int maxRepeatedDigits) {
		Map<Integer, Integer>radixMap = new HashMap<Integer, Integer>();
		while(num != 0) {
			int remainder = num%10;
			
			if(!radixMap.containsKey(remainder)) {
				radixMap.put(remainder, 0);
			}
			
			radixMap.put(remainder, radixMap.get(remainder) + 1);
			
			if(radixMap.get(remainder) > maxRepeatedDigits) {
				return true;
			}
			num = num/10;
		}
		return false;
	}
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        
        int maxRepeatedDigits = sc.nextInt();
        int numberOfQueries = sc.nextInt();
        
        for(int i = 1; i <= numberOfQueries; i++) {
        	int radix = sc.nextInt();
        	System.out.println(numberOfNumbersWithNonRepeatedDigits(maxRepeatedDigits, radix));
        }
    }
}