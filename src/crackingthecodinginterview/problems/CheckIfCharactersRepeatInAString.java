package crackingthecodinginterview.problems;

import java.util.HashSet;
import java.util.Set;
/**
 * Problem 1.1
 * @author mishra
 *
 */
public class CheckIfCharactersRepeatInAString {
	
	public static boolean isUniqueWithDataStructures(String str) {
		
		Set<String>st = new HashSet<String>();
		for(int i = 0;i <str.length();i++) {
			if( i == str.length() - 1) {
				st.add(str.substring(i));
			} else {
				st.add(str.substring(i, i+1));
			}
		}
		
		System.out.println(st.size() + "\t" + str.length());
		if( st.size() != str.length()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isUniqueWithNoDataStructures(String str) {
		
		for(int i = 0;i<str.length();i++) {
			int lastIndexofCharAtI = str.lastIndexOf(str.charAt(i));
			
			if( lastIndexofCharAtI != i ) {
				System.out.println("Repeted character\t" + str.charAt(i));
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuv";
		
		System.out.println(CheckIfCharactersRepeatInAString.isUniqueWithDataStructures(str)?"Unique characters":"Repeated characters");
		System.out.println(CheckIfCharactersRepeatInAString.isUniqueWithNoDataStructures(str)?"Unique characters":"Repeated characters");
	}
}
