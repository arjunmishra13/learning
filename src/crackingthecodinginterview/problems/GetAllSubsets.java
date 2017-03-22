package crackingthecodinginterview.problems;

import java.util.*;

/**
 * Problem 9.4
 * @author mishra
 * My solution - Using dynamic programming
 * Get previous size set, then add each new element to it
 *
 */
public class GetAllSubsets {
	
	public static Set<Set<Integer>> getAllSubsetsRecursive(Set<Integer>set, Set<Set<Integer>>allSets, Set<Set<Integer>>prevSet, int currentMaxSize) {
		if(allSets == null) {
			allSets = new HashSet<Set<Integer>>();
			Set<Integer>inner = new HashSet<Integer>();
			allSets.add(inner);
		}
		
		if(prevSet == null) {
			prevSet = new HashSet<Set<Integer>>();
		}
		
		if(currentMaxSize == set.size()) {
			System.out.println(allSets.size());
			return allSets;
		}
		
		Set<Set<Integer>>current = new HashSet<Set<Integer>>();
		if(prevSet.isEmpty()) {
			for(int val:set) {
				Set<Integer>temp = new HashSet<Integer>();
				if(!temp.contains(val)) {
					temp.add(val);
					current.add(temp);
				}
			}
		} else {
			for(Set<Integer>inner: prevSet) {
				for(int val:set) {
					Set<Integer>temp = new HashSet<Integer>(inner);
					if(!temp.contains(val)) {
						temp.add(val);
						current.add(temp);
					}
				}
			}
		}
		
		allSets.addAll(current);
		currentMaxSize++;
		return getAllSubsetsRecursive(set, allSets, current, currentMaxSize);
	}

	public static String getAllSubsets(Set<Integer>set) {
		Vector<Set<Set<Integer>>>arrays = new Vector<Set<Set<Integer>>>();
		arrays.add(new HashSet<Set<Integer>>());
		int numberOfSets = 1;
		for(int i = 1; i <= set.size(); i++) {
			Set<Set<Integer>>currentSet = new HashSet<Set<Integer>>();//copy previous set
			if(arrays.get(i - 1).isEmpty()) {
				for(int val: set) {
					Set<Integer>temp = new HashSet<Integer>();
					temp.add(val);
					currentSet.add(temp);
				}
			} else {
				for(Set<Integer>innerSet:arrays.get(i - 1)) {
					for(int val: set) {
						if(!innerSet.contains(val)) {
							Set<Integer>temp = new HashSet<Integer>(innerSet);
							temp.add(val);
							currentSet.add(temp);
						}
					}
				}
			}
			arrays.add(currentSet);
			numberOfSets += currentSet.size();
		}
		System.out.println(numberOfSets);
		return arrays.toString();
	}
	public static void main(String[] args) {

		Set<Integer>set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
//		set.add(5);

		System.out.println(getAllSubsets(set));
		System.out.println(getAllSubsetsRecursive(set, null, null, 0));
	}

}
