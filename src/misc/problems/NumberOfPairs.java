package misc.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfPairs {

	public static int numberOfPairs(int[]arr, int target) {
        int numberOfPairs = 0;
        Map<Integer, Queue<Integer>>map = new HashMap<Integer, Queue<Integer>>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new LinkedList<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        
        for(int i=0; i<arr.length; i++) {
            int diff = Math.abs(arr[i] - target);
            if(map.containsKey(diff)) {
            	for(int index: map.get(diff)) {
            		if(index != i) {
            			numberOfPairs++;
            		}
            	}
            }
        }
        
        return numberOfPairs;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int target = in.nextInt();
        int[]arr = new int[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        
        System.out.println(numberOfPairs(arr, target));
    }
}