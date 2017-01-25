package misc.problems;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class FindPermutations {

	public static Set<String> getPermutations(String str) {
		if(str.length() == 1) {
			Set<String>temp = new HashSet<String>();
			temp.add(str);
			return temp;
		}
		String start = str.substring(0, 1);
		str = str.substring(1);
		return insert(start, getPermutations(str));
	}
	
	private static Set<String> insert(String str, Set<String>strList) {
		Set<String>permutedList = new HashSet<String>();
		for(String updateStr:strList) {
			for(int i = 0;i<=updateStr.length();i++) {
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append(StringUtils.left(updateStr, i)).append(str).append(StringUtils.right(updateStr, updateStr.length() - i));
				permutedList.add(strBuilder.toString());
			}
		}
		return permutedList;
	}
	public static void main(String[] args) {
		String str = "abcddass";
		Set<String>permutations = FindPermutations.getPermutations(str); 
		System.out.println("Number of permutation\t" + permutations.size());
		System.out.println(permutations);
	}
}
