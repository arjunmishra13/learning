package crackingthecodinginterview.problems;

public class ReplaceSpaceByString {

	/**
	 * Problem 1.4
	 * @param str
	 * @return
	 */
	public static String replaceSpaceInString(String str) {
		StringBuffer resultStr = new StringBuffer();
		
		while(!str.isEmpty()) {
			
			if(str.substring(0,1).equals(" ")) {
				resultStr.append("%20");
			} else {
				resultStr.append(str.substring(0,1));
			}
			str = str.substring(1);
		}
		return resultStr.toString();
	}
	public static void main(String[] args) {
		String str = "Mr John Smith";
		System.out.println(replaceSpaceInString(str));
	}
}
