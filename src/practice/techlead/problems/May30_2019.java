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

  private static class LRUCache {
    Queue<Integer> q;
    Map<Integer, String>map;
    int cap;
    LRUCache(int n) {
      this.cap = n;
      q = new LinkedList<Integer>();
      map = new HashMap<Integer, String>();
    }

    void record(int orderId, String order) {
      if (!map.containsKey(orderId)) {
        int remid = q.remove();
        map.remove(remid);
        q.add(orderId);
        map.put(orderId, order);
      } else {
        while (q.peek() != orderId) {
          q.add(q.remove());
        }
      }
    }

    String getLast(int i) {
      if (i > q.size()) {
        return null;
      }
      int id = 0;
      Iterator<Integer> qit = q.iterator();
      while (qit.hasNext()) {
        if (id == i) {
          return map.get(qit.next());
        }
        id++;
        qit.next();
      }
      return null;
    }
  }
  public static void main(String[]args) {

    System.out.println();
  }
}
