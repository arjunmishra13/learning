package practice.techlead.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <h>Daily Coding Problem: Problem #16 [Easy]</h>
 * <p>This problem was asked by Twitter.</p>
 * <p>
 *   You run an e-commerce website and want to record the last N order ids in a log.
 *   Implement a data structure to accomplish this, with the following API:
 *
 *   record(order_id): adds the order_id to the log
 *   get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 *   You should be as efficient with time and space as possible.
 * </p>
 */
public class May30_2019 {

  /**
   * Implement a queue using an array
   */
  private static class CircularQueue {
    int size;
    int[]arr;
    int s = -1, l = 0;

    CircularQueue(int size) {
      this.size = size;
      arr = new int[size];
    }

    public void record(int orderid) {

      if (l == s) {
        s++;
      }

      arr[l++] = orderid;


      if (l == arr.length) {
        l = 0;
      }

      if (s == -1) {
        s = 0;
      } else if (s == arr.length) {
        s = 0;
      }
    }

    public int get(int i) {

      if (s == -1) {
        return -1;
      }

      int index =(s + i)%arr.length;
      return arr[index];
    }
  }
  public static void main(String[]args) {

    int n = 5;
    CircularQueue cq = new CircularQueue(5);
    System.out.println(cq.get(0));
    cq.record(1);
    cq.record(2);
    cq.record(3);
    System.out.println(cq.get(2));
    System.out.println(cq.get(1));
    cq.record(4);
    cq.record(5);
    cq.record(6);
    System.out.println(cq.get(0));
    cq.record(7);
    cq.record(8);
    System.out.println(cq.get(4));
    cq.record(9);
    cq.record(10);
    System.out.println(cq.get(0));
    cq.record(11);
    System.out.println(cq.get(0));
    cq.record(12);
    System.out.println(cq.get(0));
    System.out.println();
  }
}
