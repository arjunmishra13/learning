package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author amishra
 *
 *<h1>Non-Comparison based algorithm to sort elements using CountSort logic<h1p>
 *<h3>Space Complexity = O(n), Arrays of 10 queues, 1 for each radix, and a queue in each array position</h3>
 *<h3>Time Complexity = O(nk), where k is the maximum radix + 1 of all the numbers</h3>
 *<p>Perform radix sort by maintaining a queue for every radix 0 to 9
 *Then loop through all numbers and add them to their queues based on the
 *value of their radix. Then DeQueue and add it back to the array.
 *It would be sorted in the order of the radix used. 
 *Repeat this for all radices from 0 to max possible radix.
 *The array would be sorted because we have sorted the number with respect
 *to each of their radix</p>
 *<p>Radix Sort would clearly be slow for numbers with large radix</p>
 *
 */
public class RadixSort {

	final static ArrayList<Queue<Integer>>arrayOfQueues = new ArrayList<Queue<Integer>>(10);
	private int maxPossibleRadix = Integer.MIN_VALUE;
	public RadixSort() {
		//Initialize the arraysOfQueue
		for(int i = 0; i<10;i++) {
			arrayOfQueues.add(new LinkedList<Integer>());
		}
	}
	
	private void setMaxPossibleRadix(ArrayList<Integer> arr) {
		
		for(int i: arr) {
			int currentDecimal = 0;
			while((float)i/10.0 > 0.0) {
				i = i/10;
				currentDecimal++;
			}
			
			if(maxPossibleRadix < currentDecimal) {
				maxPossibleRadix = currentDecimal;
			}
		}
	}
	
	public ArrayList<Integer> sort(ArrayList<Integer>arr) {
		
		setMaxPossibleRadix(arr);
		int radixIndex = 0;
		while(radixIndex < maxPossibleRadix) {
			//Enqueue numbers into their queue at their calculated radix
			for(int number:arr) {
				
				int radix = getRadix(number, radixIndex);
				Queue<Integer> radixQueue = arrayOfQueues.get(radix);
				if(radixQueue == null) {
					radixQueue = new LinkedList<Integer>();
				}

				radixQueue.add(number);
			}
			
			//DeQueue and update arr
			int index = 0;
			for(Queue<Integer> queue: arrayOfQueues) {
				while(!queue.isEmpty()) {
					arr.set(index, queue.poll());
					index++;
				}
			}
			
			radixIndex++;
			
		}
		return arr;
	}
	
	private static Integer getRadix(int number, int radixIndex) {
		
		if(radixIndex != 0) {
			number = number/(int)(Math.pow(10, radixIndex));
		}
		return number%10;
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
		RadixSort radixSort = new RadixSort();
		radixSort.sort(arr);
		if(initialSize == arr.size()){
			System.out.println(arr.toString());
			System.out.println(arr.size());
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
