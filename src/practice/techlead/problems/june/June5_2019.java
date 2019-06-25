package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <hDaily Coding Problem: Problem #22 [Medium]</h>
 * <p>This problem was asked by Microsoft.</p>
 * <p>
 *    Given a dictionary of words and a string made up of those words (no spaces),
 *    return the original sentence in a list. If there is more than one possible reconstruction,
 *    return any of them. If there is no possible reconstruction, then return null.
 *
 *    For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 *    you should return ['the', 'quick', 'brown', 'fox'].
 *
 *    Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 *    return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 * </p>
 */
public class June5_2019 {

  private static List<String> splitsentance(String s, String[]sarr) {
    Set<String>words = new HashSet<String>();
    for (String w: sarr) {
      words.add(w);
    }

    List<String>sent = new ArrayList<>();
    boolean[]dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && words.contains(s.substring(j,i))) {
          dp[i] = true;
        }
      }
    }

    if (!dp[s.length()]) {
      return sent;
    } else {
      int i = 0;
      int j = i;
      while (i++ < s.length()) {
        if (dp[i]) {
          sent.add(s.substring(j,i));
          j = i;
        }
      }

      return sent;
    }
  }

  public static void main(String[]args) {

    String[]sarr = {"leet", "code"};
    System.out.println(splitsentance("leetcode", sarr));
  }
}
