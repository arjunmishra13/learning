package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * STAR STAR START algorithm
 * @author mishra
 *
 */
public class CountSortBetter {

	Vector<Integer>countArray; //Use a dynamic array because we don't know the size initially
	
	public static int[] sort(ArrayList<Integer>arr) {
		int[]output = new int[arr.size()];
		//Initialize countArray
		int max = Integer.MIN_VALUE;
		for(int number: arr) {
			if(max < number) {
				max = number;
			}
		}
		
		System.out.println(String.format("Max is [%d]. Creating an array of that size", max));
		
		int[]countArray = new int[max + 1];
		for(int number: arr) {
			countArray[number] = countArray[number] + 1;
		}
		
		//Now the count array will have last + 1 occurrence index of each character 
		for(int i = 1; i <= max; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
 		}
		/*
		 * Use the original set again to update the output array
		 * Each value in the original array get the index  
		 */
		for(int val: arr) {
			int index = countArray[val] - 1;
			output[index] = val;
			countArray[val] = index;
		}
		return output;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<Integer>arr = new ArrayList<Integer>();
		String fileName = "/Users/mishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		int initialSize = arr.size();
		int[]out = CountSortBetter.sort(arr);
		if(initialSize == out.length){
			for(int a: out) {
				System.out.print(a + " ");
			}
			System.out.println();
			System.out.println(out.length);
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
