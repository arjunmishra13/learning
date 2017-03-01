package misc.problems;

import java.util.Scanner;

public class LeftRotations {

    public static void printLeftRotatedArray(int[]arr, int rotations) {
        rotations = rotations%arr.length; 
        if(rotations == 0) {
            print(arr);
            return;
        }
        
        int[]index = new int[arr.length];
        int[]rotatedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            
            if(i - rotations < 0) {
                index[i] = arr.length + (i - rotations);
            } else {
                index[i] = i - rotations;
            }
        }
        
        for(int i =0; i <arr.length; i++) {
            int j = index[i];
            rotatedArray[j] = arr[i];
        }
        
        print(rotatedArray);
    }
    
    private static void print(int[]arr) {
        for(int i =0; i <arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        printLeftRotatedArray(a,k);
    }
}

