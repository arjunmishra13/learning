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

	static List<List<Integer>>lts = new ArrayList<>();

	private static List<List<Integer>> getAllSubsetsRecursive(int[]arr) {

		build(arr, 0, new ArrayList<Integer>());
		return lts;
	}

	private static void build(int[]arr, int i, List<Integer>lt) {
		if (i > arr.length) {
			return;
		}
		lts.add(lt);
		for (int j = i; j < arr.length; j++) {
			List<Integer>list = new ArrayList<>(lt);
			lt.add(arr[j]);
			build(arr, j + 1, list);
		}
	}

	public static void main(String[] args) {

		System.out.println(getAllSubsetsRecursive(new int[]{1,2,3}));
	}

}
