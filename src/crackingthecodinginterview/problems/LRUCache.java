package crackingthecodinginterview.problems;

import java.util.*;

public class LRUCache {

  Queue<Integer> q;
  Map<Integer, Integer>map;
  int capacity;
  public LRUCache(int capacity) {
    this.capacity = capacity;
    q = new LinkedList<Integer>();
    map = new HashMap<Integer, Integer>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      return map.get(key);
    }
    return -1;
  }

  public void put(int key, int value) {
    if (this.capacity > 0) {
      this.capacity--;
      q.add(key);
      map.put(key, value);
    }else if (map.containsKey(key)) {
      int item = map.get(key);
      while (q.peek() != item) {
        q.add(q.remove());
      }
      map.put(key, value);
    } else {
      int old = q.remove();
      map.remove(old);
      q.add(key);
      map.put(key, value);
    }
  }

  public static void main(String[]args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2,2);
    System.out.println(cache.get(1));
    cache.put(3,3);
    System.out.println(cache.get(1));

  }
}
