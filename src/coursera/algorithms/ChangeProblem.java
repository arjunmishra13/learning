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
	
	public static int getMinimumChange(int change, Vector<Integer>coins) {
		int[]minChange = new int[change + 1];
		//Find min coins for each step 
		for(int c = 1; c <= change; c++) {
			int min = 0;
			for(int denomination:coins) {
				//1 coin for using this denomination + number of coins that were used in c - denominations
				int previosMinPosition = c - denomination;
				if(previosMinPosition >= 0) {
					int numCoinsNeededWithThisDenomination = minChange[previosMinPosition] + 1;
					if(min == 0 || min > numCoinsNeededWithThisDenomination) {
						min = numCoinsNeededWithThisDenomination;
					}
				}
				
			}
			minChange[c] = min;
			
		}
		return minChange[change];
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Vector<Integer>arr = new Vector<Integer>();
		String fileName = "/Users/mishra/Desktop/Projects/Test/PossibleChange.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		int change = 60;
		System.out.println("Change\t" + change + "\t" + arr);
		System.out.println(ChangeProblem.getMinimumChange(change, arr));
	}
}
