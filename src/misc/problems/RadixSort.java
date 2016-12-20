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
 *<h1>Algorithm to sort elements using RadixSort logic<h1p>
 *<p>Space Complexity = O(n), Arrays of 10 queues, 1 for each radix, and a queue in each array position</p>
 *<p>Time Complexity = O(nk), where k is the maximum radix + 1 of all the numbers</p>
 *<p>Radix Sort would clearly be slow for numbers with large radix</p>
 *
 */
public class RadixSort {

	final static ArrayList<Queue<Integer>>arrayOfQueues = new ArrayList<Queue<Integer>>(10);
	
	public RadixSort() {
		//Initialize the arraysOfQueue
		for(int i = 0; i<10;i++) {
			arrayOfQueues.add(new LinkedList<Integer>());
		}
	}
	public ArrayList<Integer> sort(ArrayList<Integer>arr) {
		
		int radixIndex = 0;
		boolean doAllNumbersHaveZeroRadix = false;
		while(!doAllNumbersHaveZeroRadix) {
			//Enqueue numbers into their queue at their calculated radix
			for(int number:arr) {
				
				int radix = getRadix(number, radixIndex);
				Queue<Integer> radixQueue = arrayOfQueues.get(radix);
				if(radixQueue == null) {
					radixQueue = new LinkedList<Integer>();
				}

				radixQueue.add(number);
			}
			
			doAllNumbersHaveZeroRadix = (arrayOfQueues.get(0) != null || !arrayOfQueues.get(0).isEmpty()) ? (arrayOfQueues.get(0).size() == arr.size()? true: false):false;
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
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
