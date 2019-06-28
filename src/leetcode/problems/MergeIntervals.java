package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }

    Arrays.sort(intervals, startTime);
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(endTime);
    pq.add(intervals[0]);
    boolean merges = false;
    for (int i = 1; i < intervals.length; i++) {
      int[]top = pq.peek();
      if (top[1] >= intervals[i][0]) {
        pq.remove();
        top[1] = Math.max(top[1], intervals[i][1]);
        pq.add(top);
        merges = true;
      } else {
        pq.add(intervals[i]);
      }
    }

    int[][]out = new int[pq.size()][2];
    int i = pq.size() - 1;
    while(!pq.isEmpty()) {
      out[i--] = pq.remove();
    }

    return out;
  }

  Comparator<int[]>startTime = new Comparator<int[]>() {
    @Override
    public int compare(int[]a, int[]b) {
      return Integer.compare(a[0], b[0]);
    }
  };

  Comparator<int[]>endTime = new Comparator<int[]>() {
    @Override
    public int compare(int[]a, int[]b) {
      return -1*Integer.compare(a[1], b[1]);
    }
  };
}
