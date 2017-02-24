package misc.problems;

import java.util.Scanner;

public class HourGlassSum {

	public static int getHourGlassSum(int[][]arr, int rowstart, int colstart) {
		
		if(rowstart > arr.length - 3) {
			return 0;
		}
		
		if(colstart > arr.length - 3) {
			return Integer.MIN_VALUE;
		}
		int sum = Integer.MIN_VALUE;
		
		for(int i = rowstart; i< rowstart + 3; i++) {
			for(int j = colstart; j < colstart + 3; j++) {
				
				if(i == rowstart + 1) {
					if(j == colstart + 1) {
						sum += arr[i][j];
					}
				} else {
					sum += arr[i][j];
				}
			}
		}
		
		return sum;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
            	int hourSum = getHourGlassSum(arr, i, j);
            	
            	if(max < hourSum) {
            		max = hourSum;
            	}
            }
        }
        
        System.out.println(max);
    }
}

