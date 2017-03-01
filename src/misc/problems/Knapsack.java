package misc.problems;

import java.util.Scanner;

public class Knapsack {

    public static int getKnapsackValue(int[]arr, int expectedSum) {
        int[]knap = new int[expectedSum + 1];
        knap[0] = 0;
        for(int sum = 1; sum <= expectedSum; sum++) {
            
            int max = 0;
            for(int val:arr) {
                
                if(sum - val >= 0) {
                    if(max == 0 || max < (knap[sum - val] + val)) {
                        max = (knap[sum - val] + val);
                    }
                }
            }
            knap[sum] = max;
        }
        return knap[expectedSum];
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numberOfCases = sc.nextInt();
        
        while(numberOfCases > 0) {
            int size = sc.nextInt();
            int[]arr = new int[size];
            int expectedSum = sc.nextInt();
            for(int i = 0; i<size;i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getKnapsackValue(arr,expectedSum));
            numberOfCases--;
        }
    }
}