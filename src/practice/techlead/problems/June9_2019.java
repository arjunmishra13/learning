package practice.techlead.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #26 [Medium]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *    Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
 *
 *    The list is very long, so making more than one pass is prohibitively expensive.
 *
 *    Do this in constant space and in one pass.
 * </p>
 */
public class June9_2019 {

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }

  static ListNode head = null;
  static ListNode tail = null;

  private static ListNode deserialize(int[]arr) {

    ListNode curr = head;
    for (int a: arr) {
      ListNode n = new ListNode(a);
      if (head == null) {
        head = n;
        tail = n;
      } else {
        curr.next = n;
      }
      curr = n;
    }
    return head;
  }

  private static ListNode findkthlast(ListNode node, int k) {
    ListNode slow = node;
    ListNode fast = node;
    while (k-- > 0 && fast != null) {
      fast = fast.next;
    }

    if (fast == null && k > 0) {
      return null;
    } else if (fast == null) {
      return slow;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  private static List<Integer> serialize(ListNode n) {
    List<Integer>lt = new ArrayList<>();
    while (n != null) {
      lt.add(n.val);
      n = n.next;
    }
    return lt;
  }
  public static void main(String[]args) {

    int[]arr = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(serialize(findkthlast(deserialize(arr), 3)));
  }
}
