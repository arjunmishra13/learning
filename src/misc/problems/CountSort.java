package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * @author amishra
 *
 *<h1>Non-Comparison based algorithm to sort elements using CountSort logic<h1p>
 *<h3>Space Complexity = O(n), because we maintain an array that stores the count of each number, whose size is max of numbers</h3>
 *<h3>Time Complexity = O(n), because we iterate through the loop only once</h3>
 *<p>Perform count sort by iterating through the loop. The array we maintain, 
 *each position corresponds to a particular number, and the value at each position 
 *is the count of that number</p>
 *<p>Count Sort clearly would need a lot of space</p>
 *<p>Also you can only sort positive numbers using this method</p>
 *
 */
public class CountSort {

	Vector<Integer>countArray; //Use a dynamic array because we don't know the size initially
	
	public ArrayList<Integer> sort(ArrayList<Integer>arr) {
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
		
		int index = 0;
		for(int i = 0; i < countArray.length; i++) {
			int count = countArray[i];
			while(count != 0) {
				arr.set(index,i);
				index++;
				count--;
			}
		}
		return arr;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<Integer>arr = new ArrayList<Integer>();
		String fileName = "/Users/amishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		int initialSize = arr.size();
		CountSort CountSort = new CountSort();
		CountSort.sort(arr);
		if(initialSize == arr.size()){
			System.out.println(arr.toString());
			System.out.println(arr.size());
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
