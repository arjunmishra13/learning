package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Find the least number of coins to fulfill a change
 * 
 * Solved using dynamic programming, since greedy algorithm 
 * doesn't guarantee an optimal solution
 * @author mishra
 *
 */
public class ChangeProblem {

	//Dynamic programming - fill up min coins to get to each int up to target
	public int minNumberOfCoins(int target, int[]arr) {
		int []targetArr = new int[target + 1];
		for(int i = 1; i < targetArr.length; i++) {
			targetArr[i] = nextMin(targetArr, arr, i);
			System.out.print(targetArr[i] + ",");
		}
		System.out.println();
		return targetArr[target];
	}

	private int nextMin(int[]target, int[]arr, int index) {
		boolean isSet = false;
		int min = Integer.MAX_VALUE;
		for(int a:arr) {

			if (index - a >= 0 && target[index-a] != -1) {
				int val = target[index-a] + 1;
				if (min > val) {
					min = val;
					isSet = true;
				}
			}
		}
		return isSet?min:-1;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int[]arr = {2,5,7};
		int change = 10;
		System.out.println((new ChangeProblem()).minNumberOfCoins(change, arr));
	}
}
