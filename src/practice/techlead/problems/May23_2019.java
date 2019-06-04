package practice.techlead.problems;

/**
 * <h>Daily Coding Problem: Problem #9 [Hard]</h>
 * <p>This problem was asked by Airbnb.</p>
 * <p>Given a list of integers, write a function that returns the largest
 * sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13,
 * since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.</p>
 */
public class May23_2019 {

  private static int largestnonadjacentsum(int[]arr) {
      int prev = 0;
      int max = arr[0];
      for (int i = 1; i < arr.length; i++) {
        int t = max;
        max = Math.max(max, Math.max(arr[i] + prev, arr[i]));
        prev = t;
      }

      return max;
  }

  public static void main(String[]args) {

    int[]arr = {5,1,1,5};
//    int[]arr = {2,4,6,2,5};
    System.out.println(largestnonadjacentsum(arr));
  }
}
