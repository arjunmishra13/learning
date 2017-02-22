package misc.problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSort {

	//Use pivot sort
    public static void sort(String[]arr, int start, int end) {
        
    	if(start > end) {
    		return;
    	}
    	
    	int pivot = getRandom(start, end);
    	swap(arr, start, pivot);
    	
    	int j = start + 1;
    	int k = start + 1;
    	for(int i = start + 1; i <= end; i++) {
    		
    		if(isLesser(arr[i], arr[start])) {
    			swap(arr, j, i);
    			swap(arr, k, j);
    			j++;
    			k++;
    		} else if(arr[i].compareTo(arr[start]) == 0) {
    			swap(arr, j, i);
    			j++;
    		} 
    	}
    	
    	pivot = k - 1;
    	swap(arr, start, pivot);
    	
    	sort(arr, start, pivot - 1);
    	sort(arr, pivot + 1, end);
    }
    
    private static boolean isLesser(String str1, String str2) {
    	
    	BigInteger b1 = new BigInteger(str1);
    	BigInteger b2 = new BigInteger(str2);
    	return b1.compareTo(b2) < 0;
    }
    private static void swap(String[]arr, int start, int pos) {
    	String temp = arr[start];
    	arr[start] = arr[pos];
    	arr[pos] = temp;
    }
    
    private static int getRandom(int start, int end) {
    	
    	return start + (int)(Math.random()*(end - start));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        sort(unsorted, 0, unsorted.length - 1);
        for(int i = 0; i < unsorted.length; i++) {
            System.out.println(unsorted[i]);
        }
    }
}

