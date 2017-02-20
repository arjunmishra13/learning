package misc.problems;

import java.util.Scanner;

public class QuickSortInsertionSortTimeComparison {
	
	public static int getQuickSortShifts(int[]arr, int start, int end, int shifts) {

		if(start > end) {
			return shifts;
		}
		
		int pos = start;
		for(int i = start; i < end; i++) {
			if(arr[i] < arr[end]) {
				swap(arr, i, pos);
				pos++;
				shifts++;
			}
		}
		
		if(start != end) {
			swap(arr, pos, end);
			shifts++;
		}
		
		shifts = getQuickSortShifts(arr, start, pos - 1, shifts);
		shifts = getQuickSortShifts(arr, pos + 1, end, shifts);
		
		return shifts;
	}
	
	public static int getInsertionSortShifts(int[]arr) {
		int shifts = 0;

		for(int i = 1; i < arr.length; i++) {
			
			shifts = insert(arr, i, shifts);
		}
		return shifts;
	}
	
	private static int insert(int[]arr, int end, int shifts) {
		
		int target = arr[end];
		for(int i = end - 1; i >= -1; i--) {
			
			if(i >= 0 && arr[i] > target) {
				arr[i + 1] = arr[i];
				shifts++;
			} else {
				arr[i + 1] = target;
				break;
			}
		}
		
		return shifts;
	}
	
	private static void swap(int[]arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        int[]arr1 = new int[size];
        int[]arr2 = new int[size];
        for(int i = 0; i < size; i++) {
        	int num = sc.nextInt();
            arr1[i] = num;
            arr2[i] = num;
        }
        int quickSortShifts = getQuickSortShifts(arr1, 0, size - 1, 0);
        int insertionSortShifts = getInsertionSortShifts(arr2);
        
        System.out.println(insertionSortShifts - quickSortShifts);
    }
}