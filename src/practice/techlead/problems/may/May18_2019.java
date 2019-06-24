package practice.techlead.problems.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h>Daily Coding Problem: Problem #4 [Hard]</h>
 * <p>This problem was asked by Stripe.</p>
 * <p>Given an array of integers, find the first missing positive
 * integer in linear time and constant space. In other words, find the
 * lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.</p>
 * <code>
 *   For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 *   You can modify the input array in-place.
 * </code>
 */
public class May18_2019 {

  private static Integer missingNumNaive(int[]arr) {
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > 0 && arr[i] != arr[i - 1] + 1) {
        return arr[i - 1] + 1;
      }
    }
    return null;
  }

  private static Integer missingNumImproved(int[]arr) {
    Set<Integer> set = new HashSet<Integer>();
    int posmin = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean haspos = false;
    for (int a: arr) {
      set.add(a);
      if (a > 0 && posmin > a) {
        posmin = a;
        haspos = true;
      }
      max = max < a? a: max;
    }

    if (!haspos) {
      return null;
    }

    while (posmin <= max ) {
      if (!set.contains(posmin)) {
        return posmin;
      }
      posmin++;
    }

    return null;
  }

  public static void main(String[]args) {
    int[]arr = {3,4,-1,1};
//    int[]arr = {-3,-4,-1,-2};
    System.out.println(missingNumNaive(arr));
    System.out.println(missingNumImproved(arr));
  }
}
