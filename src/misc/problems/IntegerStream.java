package misc.problems;

import java.util.*;

/**
 * Indeed interview. You have a list of Stream objects
 * which have a soted integers
 * You are also given a number k
 * and you have to print every number
 * that occured >= k number of times
 * in sequence  
 * @author mishra
 *
 */
public class IntegerStream {
	/*
	 * Better approach
	 * peek at the first elements of each stream,
	 * create a map at every 
	 * if count is >= k, print and delete from stream,
	 * 
	 * To keep track of the stream a value belonged to 
	 * I have created another hashmap of value to list of streams it belonged to
	 * Also the result is added to a LinkedHashSet that will help me with checking for repeated
	 * occurences within a stream 
	 * 
	 * Time Complexity - O(SN)
	 * Space - O(S) since we iterate across first index of streams
	 */
	public static void kMerge(List<List<Integer>>streams, int k) {
		Set<Integer>result = new LinkedHashSet<Integer>();
		
		boolean checkedAll = false;
		while(!checkedAll) {
			Map<Integer, Integer>map = new HashMap<Integer, Integer>();//To store stream value count
			Map<Integer, List<Integer>>removeMap = new HashMap<Integer, List<Integer>>();//To track the stream a value belongs
			int minVal = Integer.MAX_VALUE;
			int index = 0;
			for(List<Integer>st: streams) {
				if(!st.isEmpty()) {
					int val = st.get(0);
					if(!map.containsKey(val)) {
						map.put(val, 0);
					}
					map.put(val, map.get(val) + 1);
					
					if(minVal > val) {
						minVal = val;
					}
					//Update map of value to list of stream index
					if(!removeMap.containsKey(val)) {
						removeMap.put(val, new LinkedList<Integer>());
					}
					removeMap.get(val).add(index);
				}
				index++;
			}
			
			if(map.isEmpty()) {
				checkedAll = true;
			} else {
				//Check min to see if it's count >= k
				for(int key: map.keySet()) {
					
					if(minVal == key && map.get(key) < k) {
						removeFromStream(streams, removeMap, key);
					} else if(map.get(key) >= k) {
						result.add(key);
						removeFromStream(streams, removeMap, key);
					}
				}
				
			}
		}
		
		for(int v:result) {
			System.out.print(v + "\t");
		}
		System.out.println();
	}
	private static void removeFromStream(List<List<Integer>> streams, Map<Integer, List<Integer>> removeMap, int key) {
		for(int streamIndex:removeMap.get(key)) {
			streams.get(streamIndex).remove(0);
		}
	}
	public static void main(String[] args) {
		//-8 -7 -7 -4 1 2 5 10
		List<Integer>stream1 = new LinkedList<Integer>();
		stream1.add(-8);
		stream1.add(-7);
		stream1.add(-7);
		stream1.add(-4);
		stream1.add(-1);
		stream1.add(2);
		stream1.add(5);
		stream1.add(10);
		
		//-10 -6 -4 -2 3 2
		List<Integer>stream2 = new LinkedList<Integer>();
		stream2.add(-10);
		stream2.add(-6);
		stream2.add(-4);
		stream2.add(-2);
		stream2.add(3);
		stream2.add(2);
		
		//-8 -1 1 1 3 5 6
		List<Integer>stream3 = new LinkedList<Integer>();
		stream3.add(-8);
		stream3.add(-1);
		stream3.add(1);
		stream3.add(1);
		stream3.add(3);
		stream3.add(5);
		stream3.add(6);
		int k = 2;
		
		List<List<Integer>>list = new LinkedList<List<Integer>>();
		list.add(stream1);
		list.add(stream2);
		list.add(stream3);
		
		kMerge(list, k);
	}
}
