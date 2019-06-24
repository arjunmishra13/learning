package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #18 [Hard]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *    Given an array of integers and a number k, where 1 <= k <= length of the array,
 *    compute the maximum values of each subarray of length k.
 *
 *    For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *
 *    10 = max(10, 5, 2)
 *    7 = max(5, 2, 7)
 *    8 = max(2, 7, 8)
 *    8 = max(7, 8, 7)
 *    Do this in O(n) time and O(k) space. You can modify the input array in-place
 *    and you do not need to store the results. You can simply print them out as you compute them.
 * </p>
 */
public class June1_2019 {

  //Use queues to store elements that are lesser
  public static int[] getmaxink(int[] nums, int k) {
    LinkedList<Integer>q = new LinkedList<Integer>();
    for (int i = 0; i < k; i++) {
      while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
        q.pollLast();
      }
      q.addLast(i);
    }
    int[]res = new int[nums.length - k + 1];
    int j = 0;
    for (int i = k; i < nums.length; i++) {
      int val = q.peekFirst();
      res[j++] = nums[val];
      if (val < (i - k + 1)) {
        q.pollFirst();
      }
      while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
        q.pollLast();
      }
      q.addLast(i);
    }

    if (j < res.length) {
      res[j++] = nums[q.pollFirst()];
    }

    for (int r: res) {
      System.out.print(r + ",");
    }
    System.out.println();
    return res;
  }

  private static void getmaxinknaive(int[]arr, int k) {
    for (int i = k; i <= arr.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i - k; j < i; j++) {
        if (max < arr[j]) {
          max = arr[j];
        }
      }
      System.out.print(max  + ",");
    }
  }

  public static void main(String[]args) {

    int[]arr = {1,3,-1,-3,5,3,6,7,1,2,3};
    int k = 3;
    getmaxinknaive(arr, k);
    System.out.println();
    getmaxink(arr, k);
    System.out.println();
  }
}
