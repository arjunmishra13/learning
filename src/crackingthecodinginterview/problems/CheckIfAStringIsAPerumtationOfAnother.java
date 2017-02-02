package crackingthecodinginterview.problems;

public class CheckIfAStringIsAPerumtationOfAnother {

	/**
	 * Problem 1.3
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		for(int i=0;i<str1.length();i++) {
			if(str2.indexOf(str1.charAt(i)) < 0 ){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "aaaaab";
		String str2 = "aaaaaa";
		
		System.out.println(CheckIfAStringIsAPerumtationOfAnother.isPermutation(str1, str2)?"Yes it is":"No it isn't");
	}
}
