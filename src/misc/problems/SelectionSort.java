package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Divide and conquer.
 * Return recursive solution
 * @author mishra
 *
 */
public class SelectionSort {
	
	public static Vector<Integer> sort(Vector<Integer>num, int start, int end, boolean isReverse) {
		
		if(num.isEmpty()) {
			return null;
		}
		
		if(start == end) {
			return num;
		}
		
		int maxIndex = getMaxIndex(num,start, end);
		if(isReverse) {
			int temp = num.get(start);
			num.set(start, num.get(maxIndex));
			num.set(maxIndex, temp);
			start++;
		} else {
			int temp = num.get(end);
			num.set(end, num.get(maxIndex));
			num.set(maxIndex, temp);
			end--;
		}
		return sort(num, start, end, isReverse);
	}
	
	private static int getMaxIndex(Vector<Integer>num, int start, int end) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i = start; i<=end;i++){
			
			if(max < num.get(i)) {
				max = num.get(i);
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	public static void main(String[] args) throws IOException {
		Vector<Integer>arr = new Vector<Integer>();
		
		String fileName = "/Users/mishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		
		System.out.println(SelectionSort.sort(arr, 0, arr.size()-1, false));
		System.out.println(SelectionSort.sort(arr, 0, arr.size()-1, true));
	}
}
