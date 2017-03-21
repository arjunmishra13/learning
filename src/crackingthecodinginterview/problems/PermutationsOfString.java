package crackingthecodinginterview.problems;

import java.util.*;

/**
 * Problem 9.5 - Permutations of a string of unique characters
 * @author mishra
 *
 */

public class PermutationsOfString {

	public static Set<String> getAllPermutations(String str) {
		Set<String>permutations = new HashSet<String>();
		
		for(int i = 0; i < str.length(); i++) {
			if(permutations.isEmpty()) {
				permutations.add("" + str.charAt(i));
			} else {
				Set<String>current = new HashSet<String>();
				for(String prev: permutations) {
					current.addAll(getAllArrangment(prev, str.charAt(i)));
				}
				permutations = current;
			}
		}
		
		System.out.println(permutations.size());
		return permutations;
	}
	
	private static Set<String> getAllArrangment(String str, char character) {
		Set<String>arrangements = new HashSet<String>();
		for(int i = 0; i <= str.length(); i++) {
			String temp = "";
			if(i == str.length()) {
				temp = str.substring(0, i) + character;
			} else {
				temp = str.substring(0, i) + character + str.substring(i);
			}
			arrangements.add(temp);
		}
		return arrangements;
	}
	public static void main(String[] args) {
		String str = "abcdefg";
		
		System.out.println(getAllPermutations(str));
	}
}
