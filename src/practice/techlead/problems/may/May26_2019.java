package practice.techlead.problems.may;

/**
 * <h>Daily Coding Problem: Problem #12 [Hard]</h>
 * <p>This problem was asked by Amazon.</p>
 * <p>m
 *   There exists a staircase with N steps, and you can climb up either
 *   1 or 2 steps at a time. Given N, write a function that returns the number
 *   of unique ways you can climb the staircase. The order of the steps matters.
 * </p>
 * <code>
 *   For example, if N is 4, then there are 5 unique ways:
 *
 *   1, 1, 1, 1`
 *   2, 1, 1
 *   1, 2, 1
 *   1, 1, 2
 *   2, 2
 *
 * </code>
 * <p>
 *   What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a
 *   set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 * </p>
 */
public class May26_2019 {

  private static int uniqueclimbsdp(int n, int[]arr) {
    int[]dp = new int[n + 1];

    if (n < 1) {
      return 0;
    }
    dp[n] = 1;

    //O(N*M)
    for (int i = n - 1; i >= 0; i--) {

      for (int a: arr) {
        dp[i] += (i + a < n + 1? dp[i + a]: 0);
      }
    }
    return dp[0];
  }
  private static int uniqueclimbsrec(int n, int[]arr) {

    return uclimbs(n, arr);
  }

  private static int uclimbs(int n, int[]arr) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      return 0;
    }

    int total = 0;
    for (int j = 0; j < arr.length; j++) {
      total += uclimbs(n - arr[j], arr);
    }

    return total;
  }

  public static void main(String[]args) {

    int n = 8;
    int[]arr = {1, 3, 5, 7};
    System.out.println(uniqueclimbsrec(n, arr));
    System.out.println(uniqueclimbsdp(n, arr));
  }
}
