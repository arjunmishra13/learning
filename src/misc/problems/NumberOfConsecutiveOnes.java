package misc.problems;

import java.util.Scanner;

/**
 * HackerRank
 * Convert int to boolean
 * Return number of consecutive ones
 * @author mishra
 *
 */
public class NumberOfConsecutiveOnes {

	public static int getConsecutiveOnes(int num) {
		int consecutiveOnes = 0;
		
		int sum = 0;
		while(num > 0) {
			int temp = sum;
			sum += num%2;
			
			if(temp != sum - 1) {
				sum = 0;
			} 
			consecutiveOnes = Integer.max(consecutiveOnes, sum);
			
			num = num/2;
		}
		return consecutiveOnes;
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        System.out.println(getConsecutiveOnes(num));
        
    }
}