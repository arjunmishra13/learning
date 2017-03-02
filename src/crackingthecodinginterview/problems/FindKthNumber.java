package crackingthecodinginterview.problems;

import java.util.*;

/**
 * Problem 7.7
 * Find kth number given only prime factors 3,5,7
 * 
 * My solution - Check all numbers to see if
 * they are contained in prime factors, then 
 * keep a count and once you reach k, return
 * that value 
 * 
 * Good Solution - Next number
 * is the min of product of each 3,5,7
 * 
 * Better Solution - Instead of "pulling" the next number, push out the next number
 * Keep track of all the past multiples in sorted order, 
 * and deque the first element always
 * 
 * Still Better - Maintain 3 seperate queues for 3, 5 and 7. And only compare the first element
 * on each to get min. Make sure that the new element you add is not already included
 * Trick to that is, to not add multiples of the min with a smaller queue
 * so if min is taken from queue 3 say x, the new element 3x, 5x, and 7x 
 * should be added to each. But if min is taken from queue 5 say y, then
 * only 5y, and 7y are added, since 3y, would have been included from a previous step
 * (do a small example) 
 * @author mishra
 *
 */
public class FindKthNumber {

	/*
	 * HackerRank solution
	 */
	//See better description
	static Queue<Integer>minQueue = new LinkedList<Integer>();
	public static int getKthNumberBetter(int num) {
		minQueue = new LinkedList<Integer>();
		int kthNum = 0; 
		while(num > 0) {
			
			kthNum = getMinFromQueue();
			addToQueue(kthNum);
			num--;
		}
		
		return kthNum;
	}
	
	private static int getMinFromQueue() {
		if(minQueue.isEmpty()) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		int count = 0;
		int size = minQueue.size();
		while(count < size) {
			if(min > minQueue.peek()) {
				if(min != Integer.MAX_VALUE) {
					minQueue.add(min);
				} 
				min = minQueue.poll();
			} else {
				minQueue.add(minQueue.poll());
			}
			count++;
		}
		return min;
	}
	
	private static void addToQueue(int num) {
		if(!minQueue.contains(num*3)) {
			minQueue.add(num*3);
		}
		if(!minQueue.contains(num*5)) {
			minQueue.add(num*5);
		}
		if(!minQueue.contains(num*7)) {
			minQueue.add(num*7);
		}
	}
	
	static Set<Integer>set = new HashSet<Integer>();
	public static int getKthNumberGood(int num) {
		if(num < 1) {
			return 0;
		}
		//Prep the set
		set.add(1);
		
		int currentMax = 1;
		while(set.size() < num) {
			
			int nextNum = getNextNum();
			set.add(nextNum);
			currentMax = nextNum;
		}
		
		return currentMax;
	}
	
	private static int getNextNum() {
		int min = Integer.MAX_VALUE;
		for(int val:set) {
			
			if(min > val*3 && !set.contains(val*3)) {
				min = val*3;
			} 
			
			if(min > val*5 && !set.contains(val*5)) {
				min = val*5;
			} 
			
			if(min > val*7 && !set.contains(val*7)) {
				min = val*7;
			}
		}
		
		return min != Integer.MAX_VALUE ? min : 0;
	}
	/*
	 * My solution
	 */
	public static int getKthNumberBrute(int num) {
		int val = 0;
		int count = 0;
		while( count < num) {
			val++;
			if(containedInPrime(val)) {
				count++;
			}
		}
		return val;
	}

	private static boolean containedInPrime(int val) { 

		while(val != 1) {

			if(val%3 == 0) {
				val = val/3;
			} else if(val%5 == 0) {
				val = val/5;
			} else if(val%7 == 0) {
				val = val/7;
			} else {
				return false;
			}
		}

		return true;
	}
	public static void main(String[] args) {

		int num = 9;
		System.out.println(getKthNumberGood(num));
		System.out.println(getKthNumberBetter(num));
	}
}
