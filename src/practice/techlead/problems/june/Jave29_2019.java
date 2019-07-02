package practice.techlead.problems.june;

public class Jave29_2019 {

  /**
   * <h>Daily Coding Problem: Problem #46 [Hard]</h>
   * <p>This problem was asked by Amazon.</p>
   * <code>
   *   Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.
   *
   * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
   * </code>
   */
  public static String longestpalindrome(String str) {
    String max = "";
    boolean[][]dp = new boolean[str.length()][str.length()];

    for (int diff = 0; diff < str.length(); diff++) {
      for (int i = 0; i < str.length() - diff; i++) {
        if (diff == 0) {
          dp[i][i + diff] = true;
        } else if (diff == 1) {
          if (str.charAt(i) == str.charAt(i + diff)) {
            dp[i][i + diff] = true;
          }
        } else {
          if (dp[i + 1][i + diff - 1] && str.charAt(i) == str.charAt(i + diff)) {
            dp[i][i + diff] = true;
          }
        }

        if (dp[i][i + diff] && max.length() < diff + 1) {
          max = str.substring(i, i + diff + 1);
        }
      }
    }
    return max;
  }
  public static void main(String[] args) {
    System.out.println(longestpalindrome("aabcdcb"));
    System.out.println(longestpalindrome("bananas"));
    System.out.println(longestpalindrome("bananananananans"));
    System.out.println(longestpalindrome("pwpwpwpwpw"));
  }
}
