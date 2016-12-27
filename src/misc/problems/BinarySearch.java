package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * 
 * @author amishra
 *
 *<h1>For a sorted array return the position of the matching element
 *or the position of the element where it should've been<h1p>
 *<h3>Space Complexity = O(1)</h3>
 *<h3>Time Complexity = O(log(n))</h3>
 *
 */

public class BinarySearch {

	
	public int find(Vector<Integer>sortedArray, int start, int end, int find) {
		
		if(start >= end) {
			return start;
		}
		int mid = start + (int)Math.floor((end-start)/2.0);
		if(sortedArray.get(mid) == find) {
			return mid;
		} else if( sortedArray.get(mid) < find) {
			return find(sortedArray, mid + 1, end, find);
		} else {
			return find(sortedArray, start, mid, find);
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Vector<Integer>arr = new Vector<Integer>();
		String fileName = "/Users/amishra/Desktop/Projects/Test/SearchNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		int searchFor = 10;
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(arr.toString());
		System.out.println(binarySearch.find(arr, 0, arr.size() - 1, searchFor));
	}

}
