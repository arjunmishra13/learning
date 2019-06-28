package leetcode.problems;

public class RegularExpressionMatch {

  public static boolean isMatch(String s, String p) {
    boolean[][]dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (i != 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
          System.out.println(dp[i - 1][j - 1] + ", " + i + ", " + j);
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          System.out.println((dp[i][j - 1] || dp[i][j - 2]) + ", " + i + ", " + j);
          dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
        }
      }
    }

    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aab", "c*a*b"));
  }

}
