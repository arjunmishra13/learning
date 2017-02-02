package crackingthecodinginterview.problems;

public class StringCompression {

	/**
	 * Problem 1.5
	 * @param str
	 * @return
	 */
	public static String compress(String str) {
		
		if(str.length() < 2) {
			return str;
		}
		char[]updatedString = new char [str.length()];
		int valueIndex = 0;
		
		char target = str.charAt(0);
		updatedString[valueIndex] = target;
		valueIndex++;
		int targetCount = 1;
		for(int i = 1;i<str.length();i++) {
			
			char next = str.charAt(i);
			
			if(next == target) {
				targetCount++;
				updatedString[valueIndex] = Integer.toString(targetCount).charAt(0);
			} else {
				updatedString[valueIndex] = Integer.toString(targetCount).charAt(0);
				target = next;
				if(valueIndex >= str.length() - 1) {
					return str;
				} 
				valueIndex++;
				updatedString[valueIndex] = target;
				targetCount = 1;
				valueIndex++;
				updatedString[valueIndex] = Integer.toString(targetCount).charAt(0);
			}
		}
		return new String(updatedString);
	}
	public static void main(String[] args) {
		
		String str = "aaabbaaaaaaaae";
		System.out.println(StringCompression.compress(str));
	}
}
