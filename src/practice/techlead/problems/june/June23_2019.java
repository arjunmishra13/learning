package practice.techlead.problems.june;

/**
 * <h>Daily Coding Problem: Problem #40 [Hard]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *    Given an array of integers where every integer occurs three times except for one integer,
 *    which only occurs once, find and return the non-duplicated integer.
 *
 *    For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 *
 *    Do this in O(N) time and O(1) space.
 * </p>
 */
public class June23_2019 {

  private static int findnontriplet(int[]arr) {

    int result = 0;
    for (int a: arr) {
      result ^= a;
    }
    return result;
  }

  public static void main(String[]args) {

//    int[]arr = {6, 1, 3, 3, 3, 6, 6};
    int[]arr = {3, 3, 3};
    System.out.println(findnontriplet(arr));
  }
}
