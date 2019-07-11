package crackingthecodinginterview.problems;

import java.util.*;

public class LRUCache {

  private class DoubleListNode {
    int val;
    int key;
    DoubleListNode next;
    DoubleListNode prev;

    DoubleListNode (int key, int val) {
      this.val = val;
      this.key = key;
    }

    @Override
    public String toString() {
      return Integer.toString(key);
    }
  }

  int size;
  Map<Integer, DoubleListNode>map;
  DoubleListNode head;
  DoubleListNode tail;
  public LRUCache(int capacity) {
    this.size = capacity;
    this.map = new HashMap<Integer, DoubleListNode>();
  }

  public int get(int key) {
    DoubleListNode top = remove(key);
    if (top == null) {
      return -1;
    }
    add(key, top);
    return top.val;
  }

  public void put(int key, int value) {
    remove(key);

    DoubleListNode node = new DoubleListNode(key, value);
    add(key, node);
  }

  private void add(int key, DoubleListNode node) {


    if (map.size() == size) {
      if (tail != null) {
        map.remove(tail.key);
        tail = tail.prev;
      }

      if (tail != null) {
        tail.next = null;
      }
    }

    if (tail == null) {
      tail = node;
    }

    DoubleListNode temp = head;
    head = node;
    head.next = temp;
    if (temp != null) {
      temp.prev = head;
    }

    map.put(key, node);
  }

  private DoubleListNode remove(int key) {
    if (map.containsKey(key)) {

      DoubleListNode node = map.remove(key);

      if (tail == node) {
        tail = node.prev;
      }

      if (node.prev != null) {
        node.prev.next = node.next;
      }

      if (node.next != null) {
        node.next.prev = node.prev;
      }

      node.next = null;
      node.prev = null;

      return node;
    }

    return null;
  }

  public static void main(String[]args) {
    LRUCache cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(3,2);
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    cache.put(4,3);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));

  }
}
