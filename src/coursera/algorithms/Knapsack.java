package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the highest value without exceeding the weight
 * 
 * Solved using dynamic programming
 * @author mishra
 *
 */
public class Knapsack {

	public static int getMaxValueWithRepetitions(int maxWeight, List<Item<Integer, Integer>> items) {
		int[]valueArray = new int[maxWeight+1];
		for(int w = 1; w <= maxWeight;w++) {
			int maxValue = 0;
			for(Item<Integer, Integer> it:items) {
				int weightDiff = w - it.weight.intValue();
				if(weightDiff >= 0) {
					int newValue = valueArray[weightDiff] + it.value;
					if(maxValue == 0 || maxValue < newValue) {
						maxValue = newValue;
					}
				}
			}
			valueArray[w] = maxValue;
		}
		return valueArray[maxWeight];
	}
	
	/*
	 * Trick is to check for first element all max values, then first 2, then first 3, and so on till all are considered
	 */
	public static int getMaxValueWithoutRepetitions(int maxWeight, List<Item<Integer, Integer>> items) {
		int[][]valueArray = new int[maxWeight+1][items.size()];
		for(int n = 0; n< items.size(); n++) {
			for(int w = 1; w<= maxWeight; w++) {
				valueArray[w][n] = n > 1? valueArray[w][n - 1]: 0;
				if(items.get(n).weight <= w) {
					int newValue = (n > 1?valueArray[w - items.get(n).weight][n - 1]:0) + items.get(n).value;
					if(newValue > valueArray[w][n]) {
						valueArray[w][n] = newValue;
					}
				}
			}
		}
		//Get items added
		int[]wasAdded = new int[items.size()];
		int tempWeight = maxWeight;
		for(int n = items.size() - 1;n >= 0;n--) {
			if(n == 0) {
				if(valueArray[tempWeight][n] == items.get(0).value) {
					wasAdded[n] = 1;
				}
			} else {
				if(valueArray[tempWeight][n] == valueArray[tempWeight][n - 1]) {
					wasAdded[n] = 0;
				} else {
					wasAdded[n] = 1;
					tempWeight = tempWeight - items.get(n).weight;
				}
			}
		}
		System.out.print("Items Added With Repetions:\t");
		for(int a:wasAdded) {
			System.out.print(a + "\t");
		}
		System.out.println();
		return valueArray[maxWeight][items.size()-1];
	}

	/**
	 * Knapsack problem (not fractional) with repetitions is an
	 * NP-Hard problem. But it can be solved with Dynamic Programming
	 * better than any other known approaches
	 * 
	 * Max Value at weight W = Max Value at weight W - wi + Value of wi, for all i
	 */
	
	public static void main(String[] args) throws IOException {
		Integer maxWeight = 20;
		
		String fileName = "/Users/mishra/Desktop/Projects/Test/Knapsack.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		List<Item<Integer, Integer>>items = new LinkedList<Item<Integer, Integer>>();
		while(line != null) {
			String[] arr = line.split("\t");
			int weight = Integer.parseInt(arr[0]);
			int value = Integer.parseInt(arr[1]);
			Item<Integer, Integer>item = new Item<Integer, Integer>(weight, value);
			items.add(item);
			line = bufferedReader.readLine();
		}

		bufferedReader.close();
		System.out.println("Weight Capacity\t" + maxWeight + "\t" + items.toString());
		System.out.println("With Repetitions\t" + Knapsack.getMaxValueWithRepetitions(maxWeight, items));
		System.out.println("Without Repetitions\t" + Knapsack.getMaxValueWithoutRepetitions(maxWeight, items));
	}
}
