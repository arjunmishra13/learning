package practice.techlead.problems.june;

/**
 * <h>Daily Coding Problem: Problem #25 [Hard]</h>
 * <p>This problem was asked by Facebook.</p>
 * <p>
 *    Implement regular expression matching with the following special characters:
 *
 *    . (period) which matches any single character
 *    * (asterisk) which matches zero or more of the preceding element
 *    That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
 *
 *    For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.
 *
 *    Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
 * </p>
 */
public class June8_2019 {
  /**
   * <case>
   *   1. string char at i ==  pattern char at j or pattern char at j == '.'
   *      dp[i][j] {} = dp[i - 1][j - 1]
   *   2. pattern char at j == '*'
   *   2.a. 0 matches
   *      dp[i][j] {} = dp[i][j - 2]
   *   2.b. 1 match: char at j - 1 is a '.' or matches with char at i
   *      dp[i][j] {} = dp[i - 1][j - 2]
   *   2.c. multiple matches: char at j - 1 is a '.' or matches with char at i
   *      dp[i][j] {} = dp[i - 1][j]
   * </case>
   */
  private static boolean regexmatch(String str, String pattern) {


    boolean[][]dp = new boolean[str.length() + 1][pattern.length() + 1];
    dp[0][0] = true; //empty pattern matches with empty string since they are equal
    for (int i = 0; i <= str.length(); i++) {
      for (int j = 1; j <= pattern.length(); j++) {
        if (pattern.charAt(j - 1) == '.' || (i > 0 && pattern.charAt(j - 1) == str.charAt(i - 1))) {
          dp[i][j] = i > 0? dp[i - 1][j - 1]:true;
        } else if (pattern.charAt(j - 1) == '*') {
          //0 matches
          dp[i][j] = dp[i][j - 2];
          if (pattern.charAt(j - 2) == '.' || (i > 0 && pattern.charAt(j - 2) == str.charAt(i - 1))) { //1 or multiple matches
            dp[i][j] =  dp[i][j] || dp[i][j - 2] || dp[i - 1][j];
          }
        }
      }
    }
    return dp[str.length()][pattern.length()];
  }

  public static void main(String[]args) {

    System.out.println(regexmatch("ray","ra."));
    System.out.println(regexmatch("raymond","ra."));
    System.out.println(regexmatch("chat",".*at"));
    System.out.println(regexmatch("chats",".*at"));
  }
}
