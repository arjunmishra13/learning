package practice.techlead.problems.may;

import java.util.HashSet;
import java.util.Set;

/**
 * May 15, 2019
 * <h>Daily Coding Problem: Problem #1 [Easy]</h>
 * <p>This problem was recently asked by Google.</p>
 * <p>Given a list of numbers and a number k, return whether any two numbers from the list add up to k.</p>
 * <p>For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.</p>
 */
public class May15_2019 {

  //Space O(N) Time O(N). Single scan
  private static boolean doesAddToK(int[]arr, int k) {

    Set<Integer> set = new HashSet<Integer>();

    for (int a: arr) {
      if (set.contains(k - a)) {
        return true;
      } else {
        set.add(a);
      }
    }
    return false;
  }

  public static void main(String[]args) {

    int[]arr = {10,15,3,7};
    int k = 12;
    System.out.println(doesAddToK(arr,k));
  }

}
