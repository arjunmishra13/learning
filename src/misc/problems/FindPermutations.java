package misc.problems;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;


public class FindPermutations {

	public static Set<String> getPermutations(String str, Set<String>set) {
			return null;
	}

	public static void main(String[] args) {
		String str = "abcddass";
		Set<String>permutations = getPermutations(str, new HashSet<String>());
		System.out.println("Number of permutation\t" + permutations.size());
		System.out.println(permutations);
	}
}
