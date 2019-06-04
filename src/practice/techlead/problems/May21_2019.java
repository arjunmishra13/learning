package practice.techlead.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <h>Daily Coding Problem: Problem #7 [Medium]</h>
 * <p>This problem was asked by Facebook.</p>
 * <p>Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.</p>
 */
public class May21_2019 {

  /**
   * Using memoization. Recurrence relation
   * T(i) = T(i-1) or T(i-1) + 1 if last two are under 26
   * @param str
   * @return
   */
  private static int numberOfDecodableStrings(String str) {
    if (str == null || str.length() == 0){
      return 0;
    }

    int[]dp = new int[str.length()];

    dp[0] = 1;
    for (int i = 1; i < str.length(); i++) {
      if (isValid(str, i - 1, i)) {
        dp[i] = dp[i - 1] + (i > 1? dp[i - 2]:1);
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[str.length() - 1];
  }

  private static int numberOfDecodableStrings2(String str) {
    if (str == null || str.length() == 0){
      return 0;
    }

    int[]dp = new int[str.length()];

    dp[str.length() - 1] = 1;
    for (int i = str.length() - 2; i>= 0; i--) {
      if (isValid(str, i, i + 1)) {
        dp[i] = dp[i + 2];
      }
      dp[i] += dp[i + 1];
    }
    return dp[0];
  }

  private static boolean isValid(String str, int i, int j) {
    if (j >= str.length()){
      return false;
    }
    if ((str.charAt(i) - '0') > 2) {
      return false;
    } else if ((str.charAt(i) - '0') > 1 && (str.charAt(j) - '0') > 6) {
      return false;
    }
    return true;
  }

  public static void main(String[]args) {

    String str = "11234";
//    String str = "1234456788902101235688";
    System.out.println(numberOfDecodableStrings(str));
    System.out.println(numberOfDecodableStrings2(str));
  }
}
