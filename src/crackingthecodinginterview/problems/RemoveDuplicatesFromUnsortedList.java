package crackingthecodinginterview.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem 2.1
 * @author mishra
 *
 */
public class RemoveDuplicatesFromUnsortedList {

	public static List<Integer> removeDuplicates(List<Integer>list) {
		List<Integer>buffer = new LinkedList<Integer>();
		Iterator<Integer>listItr = list.iterator();
		while(listItr.hasNext()) {
			
			int nextNum = listItr.next();
			if(!buffer.contains(nextNum)) {
				buffer.add(nextNum);
			}
		}
		
		return buffer;
	}
	
	public static void removeDuplicatesNoBuffer(List<Integer>list, int index) {
		
		if(list.isEmpty() || index == list.size()) {
			return;
		}
		boolean isDuplicateFound = false;
		int tempIndex = index + 1;
		int subject = list.get(index);
		while(!isDuplicateFound && tempIndex<list.size()) {
			if(list.get(tempIndex) == subject) {
				isDuplicateFound = true;
			}
			tempIndex++;
		}
		
		if(isDuplicateFound) {
			list.remove(index);
		} else {
			index++;
		}
		removeDuplicatesNoBuffer(list, index);
	}

	public static void main(String[] args) {
		
		List<Integer>nums = new LinkedList<Integer>();
		int size = 10;
		while(size > 0) {
			nums.add((int)(Math.random()*10));
			size--;
		}
		
		System.out.println(nums);
		List<Integer>nums2 = nums;
		nums = RemoveDuplicatesFromUnsortedList.removeDuplicates(nums);
		RemoveDuplicatesFromUnsortedList.removeDuplicatesNoBuffer(nums2, 0);
		System.out.println(nums);
		System.out.println(nums2);
	}
}
