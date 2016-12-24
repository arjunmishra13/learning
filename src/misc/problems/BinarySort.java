package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author amishra
 *
 *<h1>Comparison based algorithm to sort elements using BinarySort logic<h1p>
 *<h3>Space Complexity = O(1)</h3>
 *<h3>Time Complexity = O(n-squared)</h3>
 *<p>Keep pushing the max to the end for n, n-1, n-2, ... 1 elements</p>
 *<p>Non-optimal solution. We can do better</p>
 *
 */
public class BinarySort {

	
	public ArrayList<Integer> sort(ArrayList<Integer>arr) {
		
		for(int i = 0;i<arr.size();i++) {
			for(int j = 0;j<arr.size() - i - 1;j++) {
				if(arr.get(j) > arr.get(j+1)) {
					int temp = arr.get(j + 1);
					arr.set(j+1, arr.get(j));
					arr.set(j, temp);
				}
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
		BinarySort BinarySort = new BinarySort();
		BinarySort.sort(arr);
		if(initialSize == arr.size()){
			System.out.println(arr.toString());
			System.out.println(arr.size());
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
