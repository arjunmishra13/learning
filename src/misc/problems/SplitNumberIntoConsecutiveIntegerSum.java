package misc.problems;

import java.util.ArrayList;
import java.util.List;

public class SplitNumberIntoConsecutiveIntegerSum {

  /***
   * Given a long integer find number of ways to split it up into 2 or more consecutive positive integers
   * 21 - 3
   * {1,2,3,4,5,6}, {6,7,8}, {10,11}
   */

  private static List<List<Integer>> splitIntoConsecIntSums(int num) {
    List<List<Integer>>lt = new ArrayList<>();

    int max = num/2 + 1;
    int start = 1;
    while (start <= max) {

      int sum = 0;
      List<Integer>out = new ArrayList<>();
      int i = start;
      while (i <= max) {
        out.add(i);
        sum += i;
        if (sum == num) {
          lt.add(out);
          break;
        } else if (sum > num) {
          break;
        }
        i++;
      }
      start++;
    }

    return lt;
  }

  public static void main(String[] args) {
    System.out.println(splitIntoConsecIntSums(13));
  }
}
