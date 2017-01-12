package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Insertion sort involves finding position of the pivot element
 * and moving it there in such a way that everything to its left
 * is lesser than it, and everything to it's right is at most it
 * 
 * Time Complexity avg case n*log(n). If tree is unbalanced it will be n-squared
 * Space complexity is worst case log(n)
 * To handle worst case pick a random pivot 
 * Will fail when elements are all equal. So need to keep track of lesser, equal and strictly greater index
 * @author mishra
 *
 */
public class InsertionSort<T extends Number> {
	
	public static <T extends Number> Vector<T> sort(Vector<T>nums, int start, int end) {
		
		if(start >= end) {
			return nums;
		}
		
		int pivotPosition = insertRandomPivotHandleEqualElements(nums, start, end);
		sort(nums, start, pivotPosition - 1);
		sort(nums, pivotPosition + 1, end);
		
		return nums;
	}
	
	@SuppressWarnings("unused")
	@Deprecated
	private static <T extends Number> int insertPivot(Vector<T>nums, int start, int end) {
		T pivot = nums.get(start);
		int j = start + 1;
		for(int i = start + 1;i <= end; i++) {
			
			if(nums.get(i).doubleValue() < pivot.doubleValue()) {
				//swap i'th element with j'th element
				T temp = nums.get(i);
				nums.set(i, nums.get(j));
				nums.set(j, temp);
				j++;
			}
		}
		
		//swap pivot with jth element
		nums.set(start, nums.get(j - 1));
		nums.set(j - 1, pivot);
		
		return j-1;
	}
	
	@SuppressWarnings("unused")
	@Deprecated
	private static <T extends Number> int insertRandomPivot(Vector<T>nums, int start, int end) {
		int randomPivotPosition = start + ((int)Math.floor(10*Math.random())%(end- start));
		//swap this with first index
		T temp1 = nums.get(randomPivotPosition);
		nums.set(randomPivotPosition, nums.get(start));
		nums.set(start, temp1);
		
		T pivot = nums.get(start);
		int j = start + 1;
		for(int i = start + 1;i <= end; i++) {
			
			if(nums.get(i).doubleValue() < pivot.doubleValue()) {
				//swap i'th element with j'th element
				T temp = nums.get(i);
				nums.set(i, nums.get(j));
				nums.set(j, temp);
				j++;
			}
		}
		
		//swap pivot with jth element
		nums.set(start, nums.get(j - 1));
		nums.set(j - 1, pivot);
		
		return j-1;
	}
	
	private static <T extends Number> int insertRandomPivotHandleEqualElements(Vector<T>nums, int start, int end) {
		int randomPivotPosition = start + ((int)Math.floor(10*Math.random())%(end- start));
		//swap this with first index
		T temp0 = nums.get(randomPivotPosition);
		nums.set(randomPivotPosition, nums.get(start));
		nums.set(start, temp0);
		
		T pivot = nums.get(start);
		int j = start + 1;//position of equal elements. If there are no equal elements it will always be equal to k
		int k = j;//position of strictly greater elements
		for(int i = start + 1;i <= end; i++) {
			
			if(nums.get(i).doubleValue() < pivot.doubleValue()) {
				//swap i'th element with k'th element
				T temp1 = nums.get(i);
				nums.set(i, nums.get(k));
				nums.set(k, temp1);
				
				//Then swap the new k'th element with j'th element
				T temp2 = nums.get(k);
				nums.set(k, nums.get(j));
				nums.set(j, temp2);
				k++;
				j++;
			} else if(nums.get(i).doubleValue() == pivot.doubleValue()) {
				//swap i'th element with k'th element
				T temp = nums.get(i);
				nums.set(i, nums.get(k));
				nums.set(k, temp);
				k++;
			}
		}
		
		//swap pivot with jth element
		nums.set(start, nums.get(j - 1));
		nums.set(j - 1, pivot);
		
		return j - 1;
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
		int initialSize = arr.size();
		InsertionSort.sort(arr, 0, initialSize - 1);
		if(initialSize == arr.size()){
			System.out.println(arr.toString());
			System.out.println(arr.size());
		} else {
			System.out.println("Different Size of elements returned");
		}
	}
}
