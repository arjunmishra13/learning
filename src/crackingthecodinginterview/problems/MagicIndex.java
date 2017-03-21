package crackingthecodinginterview.problems;

public class MagicIndex {
/**
 * Problem 9.3 - Magic Index, one where arr[i] = i
 * Check out my method for duplicates, where I set start to start + 1, if no match
 * Book method is better. One solution handles both duplicates and without duplicates
 * Check mid, then left then right
 * if mid == arr[mid], return mid,
 * <b>leftIndex = min(mid - 1, arr[mid]), rightIndex = max(mid + 1, arr[mid])
 */
	public static int findMagicIndexBook(int[]arr) {
		int start = 0; 
		int end = arr.length - 1;
		return findMagicIndexBook(arr, start, end);
	}
	public static int findMagicIndexDistinct(int[]arr) {
		int start = 0;
		int end = arr.length - 1;
		return findMagicIndexBinarySearchDistinct(arr, start, end);
	}
	
	public static int findMagicIndexRepeted(int[]arr) {
		int start = 0;
		int end = arr.length - 1;
		return findMagicIndexRepeted(arr, start, end);
	}
	
	public static int findMagicIndexBook(int[]arr, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		
		int mid = start + (end - start)/2;
		if(arr[mid] == mid) {
			return mid;
		}
		
		int leftIndex = Integer.min(mid - 1, arr[mid]);
		int left = findMagicIndexBook(arr, start, leftIndex);
		
		if(left >= 0) { 
			return left;
		}
			
		int rightIndex = Integer.max(mid + 1, arr[mid]);
		return findMagicIndexBook(arr, rightIndex, end);
	}
	public static int findMagicIndexRepeted(int[]arr, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		
		int mid = start + (end - start)/2;
		
		if(arr[mid] == mid) {
			return mid;
		} else if(arr[mid] > mid) {
			if(arr[start] == start) {
				return start;
			} else {
				return findMagicIndexRepeted(arr, start + 1, end);
			}
		} else {
			return findMagicIndexRepeted(arr, mid + 1, end);
		}
		
		
	}
	
	public static int findMagicIndexBinarySearchDistinct(int[]arr, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		int mid = start + (end - start)/2;
		
		if(arr[mid] == mid) {
			return mid;
		} else if(arr[mid] > mid) {
			return findMagicIndexBinarySearchDistinct(arr, start, mid - 1);
		} else {
			return findMagicIndexBinarySearchDistinct(arr, mid + 1, end);
		}
	}
	
	public static int findMagicIndexAll(int[]arr) {
		
		int magicIndex = -1;
		for(int i = 0; i < arr.length; i++) {
			if(i == arr[i]) {
				return i;
			}
		}
		return magicIndex;
	}
	public static void main(String[] args) {
		int n = 5;
		
		int[]arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 4;
		arr[4] = 4;
		
		System.out.println(findMagicIndexBook(arr));
	}
}
