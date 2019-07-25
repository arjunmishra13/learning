package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ReverseKListNode {

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return Integer.toString(val);
    }
  }

  public static ListNode deserialize(int[]arr) {
    ListNode head = null;
    ListNode curr = null;
    for (int a: arr) {
      ListNode node = new ListNode(a);
      if (head == null) {
        head = node;
        curr = node;
      }
      curr.next = node;
      curr = node;
    }
    return head;
  }

  private static List<Integer> serialize(ListNode node) {
    List<Integer>lt = new ArrayList<>();
    while (node != null) {
      lt.add(node.val);
      node = node.next;
    }
    return lt;
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    int origk = k;
    ListNode curr = head;
    ListNode tail = null;
    ListNode top = tail;

    if (!hasK(head, k)) {
      return curr;
    }

    while (curr != null && k-- > 0) {
      ListNode temp = curr.next;
      curr.next = top;
      top = curr;
      if (tail == null) {
        tail = curr;
      }
      curr = temp;
    }

    if (k < 0 && tail != null) {
      tail.next = reverseKGroup(curr, origk);
    } else {
      return head;
    }

    return top;
  }

  private static boolean hasK(ListNode node, int k) {
    while (node != null) {
      if (k-- == 0) {
        return true;
      }
      node = node.next;
    }
    return k == 0;
  }

  public static void main(String[] args) {
    ListNode head = deserialize(new int[]{1,2,3,4,5});
    System.out.println(serialize(reverseKGroup(head, 3)));
  }
}
