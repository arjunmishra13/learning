package misc.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

/**
 * TODO - Need to find a more optimal solution
 * @author mishra
 *
 */
public class AllPossibleChange {

    public static int getPossibleCombinations(int sum, int[]arr) {
    	Vector<Set<Map<Integer, Integer>>>combinations = new Vector<Set<Map<Integer, Integer>>>();
    	combinations.add(new HashSet<Map<Integer, Integer>>());
        for(int i = 1; i <= sum; i++) {
        	combinations.add(new HashSet<Map<Integer, Integer>>());
        	System.out.println(i);
        	for(int j = 0; j < arr.length; j++) {
        		
        		if(i - arr[j] >= 0) {
        			int diff = i - arr[j];
        			
        			if(combinations.get(diff).isEmpty()) {
        				if(arr[j] == i) {
	        				Map<Integer, Integer> gp = new HashMap<Integer, Integer>();
	        				if(!gp.containsKey(arr[j])) {
	        					gp.put(arr[j], 0);
	        				}
	        				gp.put(arr[j], gp.get(arr[j]) + 1);
	        				
	        				combinations.get(i).add(gp);
        				}
        			} else {
	        			for(Map<Integer, Integer> gp:combinations.get(diff)) {
	        				Map<Integer, Integer>mp1 = new HashMap<Integer, Integer>(gp);
	        				if(!mp1.containsKey(arr[j])) {
	        					mp1.put(arr[j], 0);
	        				}
	        				
	        				mp1.put(arr[j], mp1.get(arr[j]) + 1);
	        				combinations.get(i).add(mp1);
	        			}
        			}
        		}
        	}
        	
        }
        return combinations.get(sum).size();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int changeSize = sc.nextInt();
        int[]arr = new int[changeSize];
        for(int i =0; i< changeSize; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(getPossibleCombinations(sum, arr));
    }
}