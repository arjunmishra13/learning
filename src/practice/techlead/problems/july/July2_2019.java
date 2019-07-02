package practice.techlead.problems.july;

public class July2_2019 {

  /**
   * <h>Daily Coding Problem: Problem #49 [Medium]</h>
   * <p>This problem was asked by Amazon.</p>
   * <code>
   *   Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
   *
   * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
   *
   * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
   *
   * Do this in O(N) time.
   * </code>
   */
  private static int kadane(int[]arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int sum = arr[0];
    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (sum < 0) {
        sum = arr[i];
      } else {
        sum += arr[i];
      }
      max = Math.max(max, sum);
    }

    return Math.max(max, 0);
  }
  public static void main(String[] args) {
    System.out.println(kadane(new int[]{34, -50, 42, 14, -5, 86}));
    System.out.println(kadane(new int[]{-5, -1, -8, -9}));
  }
}
