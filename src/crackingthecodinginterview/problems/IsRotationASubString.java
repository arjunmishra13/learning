package crackingthecodinginterview.problems;

/**
 * Problem 1.8
 * @author mishra
 *
 */
public class IsRotationASubString {
	/*
	 * If str1 is a permutation of str2
	 */
	public static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		str2 += str2;
		
		return isSubstring(str1, str2);
	}
	/*
	 * Is string1 a substring of string 2
	 */
	public static boolean isSubstring(String str1, String str2) {
		
		if(str2.length() < str1.length()) {
			return false;
		}
		
		for(int i=0;i<str2.length() - str1.length();i++) {
			if(str1.equals(str2.substring(i, i+str1.length()))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str1 = "efghijabcd";
		String str2 = "abcdefghij";
		System.out.println(IsRotationASubString.isPermutation(str1, str2));
	}
}
