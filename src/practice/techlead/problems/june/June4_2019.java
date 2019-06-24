package practice.techlead.problems.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h>Daily Coding Problem: Problem #21 [Easy]</h>
 * <p>This problem was asked by Snapchat.</p>
 * <p>
 *    Given an array of time intervals (start, end) for classroom
 *    lectures (possibly overlapping), find the minimum number of rooms required.
 *
 *    For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 * </p>
 */
public class June4_2019 {

  private static int minrooms(int[][]arr) {

    Arrays.sort(arr, startTimeSort);

    PriorityQueue<int[]>pq = new PriorityQueue<int[]>(endTimeSort);
    pq.add(arr[0]);
    int classes = 1;

    for (int i = 1; i < arr.length; i++) {
      int[]next = arr[i];
      if (pq.isEmpty() || next[0] < pq.peek()[1]) {
        classes++;
        pq.add(next);
      } else {
        pq.remove();
        pq.add(next);
      }
    }

    return classes;
  }

  static Comparator<int[]>startTimeSort = new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[0], o2[0]);
    }
  };

  static Comparator<int[]>endTimeSort = new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[1], o2[1]);
    }
  };

  public static void main(String[]args) {

//    int[][]arr = {{30,75},{0,50},{60,150}};
    int[][]arr = {{7,10},{2,4}};
    System.out.println(minrooms(arr));
  }
}
