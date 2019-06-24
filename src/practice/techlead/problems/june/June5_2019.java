package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

  private static List<String> splitsentance(String str, String[]sarr) {
    Set<String>dict = new HashSet<>();
    for (String s: sarr) {
      dict.add(s);
    }

    //DP solution on O(n-square) time
    /**
     * Use T(i) = T(i - 1)&&match
     */
    boolean[]dp = new boolean[str.length() + 1];
    return null;
  }

  public static void main(String[]args) {

    String[]sarr = {"bed", "bath", "bedbath", "and", "beyond"};
    System.out.println(splitsentance("bedbathandbeyond", sarr));
  }
}
