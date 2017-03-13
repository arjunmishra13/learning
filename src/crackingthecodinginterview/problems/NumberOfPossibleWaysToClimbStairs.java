package crackingthecodinginterview.problems;

/**
 * Problem 9.1
 * 
 * My solution - DP - C[n] = c[n - 1] + c[n - 2] + c[n - 3], if n - k == 0, c[n - k] = 1
 * 
 * @author mishra
 *
 */
public class NumberOfPossibleWaysToClimbStairs {

	public static int getNumberOfPossibleSteps(int n) {
		if( n < 1) {
			return 0;
		}
		int[]steps = new int[n+1];
		steps[0] = 1;
		for(int i = 1; i <= n; i++) {
			if(i - 1 >= 0) {
				steps[i] += steps[i - 1];
			}
			if(i - 2 >= 0) {
				steps[i] += steps[i - 2];
			}
			if(i - 3 >= 0) {
				steps[i] += steps[i - 3];
			}
		}
		return steps[n];
	}
	
	public static int getNumberOfPossibleRecurssion(int n) {
		
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}

		return getNumberOfPossibleRecurssion(n - 1) + getNumberOfPossibleRecurssion(n - 2) + getNumberOfPossibleRecurssion(n - 3);
	}
	
	public static void main(String[] args) {
		int n = 7;
		System.out.println(getNumberOfPossibleSteps(n));
		System.out.println(getNumberOfPossibleRecurssion(n));
	}
}
