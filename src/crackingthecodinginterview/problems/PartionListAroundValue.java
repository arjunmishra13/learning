package crackingthecodinginterview.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PartionListAroundValue {

	/**
	 * Problem 2.4 - Similar to pivot sort - Best case(pivot is largest) O(n)  Worst Case(pivot is smallest) O(n-squared)
	 * @param args
	 */
	public static void partitionAroundValue(List<Integer>list, int pivotIndex) {

		if(list.size() < 2) {
			return;
		}
		//make the pivot the first element
		swap(list, 0, pivotIndex);
		
		Iterator<Integer>listItr = list.iterator();
		int pivot = listItr.next();
		int indexOfSmallestGreaterElement = 1;
		int index = 1;
		//O(n)
		while(listItr.hasNext()) {
			int next = listItr.next();
			
			if(next < pivot) {
				//swap next with index of smallest greater elements 
				swap(list, index, indexOfSmallestGreaterElement);
				indexOfSmallestGreaterElement++;
			}
			index++;
		}
		
		//swap the pivot with index of smallest greater elements - 1
		swap(list, 0, indexOfSmallestGreaterElement - 1);
	}

	//O(n)
	private static void swap(List<Integer> list, int index1, int index2) {
		int temp = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}
	
	public static void main(String[] args) {

		List<Integer>nums = new LinkedList<Integer>();
		int size = 10;
		int pivotIndex = 3;
		while(size > 0) {
			nums.add((int)(Math.random()*10));
			size--;
		}

		System.out.println(nums + "\t" + nums.get(pivotIndex));
		PartionListAroundValue.partitionAroundValue(nums, pivotIndex);
		System.out.println(nums);
	}
}
