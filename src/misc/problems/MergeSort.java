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
 *<h1>Sort arrays by splitting into sorted arrays recursively and then merging them.
 * Merge Sort is asymptotically optimal<h1p>
 *<h3>Space Complexity = O(n)</h3>
 *<h3>Time Complexity = O(nlog(n))</h3>
 *
 */

public class MergeSort<T> {

	
	public static <T extends Number> Vector<T> mergeSort(Vector<T>sortedArray, int start, int end) {
		if(start >= end) {
			Vector<T> array = new Vector<T>();
			array.add(sortedArray.get(start));
			return array;
		}
		int mid = start + (int)Math.floor((end - start)/2.0);
		Vector<T>array1 = mergeSort(sortedArray, start, mid);
		Vector<T>array2 = mergeSort(sortedArray, mid + 1, end);
		
		return merge(array1, array2);
	}
	
	private static <T extends Number> Vector<T> merge(Vector<T>array1, Vector<T>array2) {
		Vector<T>mergedArray =  new Vector<T>();
		
		while(!array1.isEmpty() || !array2.isEmpty()) {
			
			if(array1.isEmpty()) {
				mergedArray.addAll(array2);
				array2.clear();
			} else if(array2.isEmpty()) {
				mergedArray.addAll(array1);
				array1.clear();
			} else if(array1.get(0).doubleValue() < array2.get(0).doubleValue()) {
				mergedArray.add(array1.get(0));
				array1.remove(0);
			} else {
				mergedArray.add(array2.get(0));
				array2.remove(0);
			}
		}
		return mergedArray;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Vector<Integer>arr = new Vector<Integer>();
		String fileName = "/Users/mishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		System.out.println(arr.toString());
		System.out.println(MergeSort.mergeSort(arr, 0, arr.size() - 1));
	}

}
