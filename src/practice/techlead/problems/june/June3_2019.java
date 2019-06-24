package practice.techlead.problems.june;

/**
 * <h>Daily Coding Problem: Problem #20 [Easy]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *  Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 *  For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 *  In this example, assume nodes with the same value are the exact same node objects.
 *
 *  Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 * </p>
 */
public class June3_2019 {

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
  private static ListNode deserialize(int[]arr) {
    ListNode start = new ListNode(-1);
    ListNode temp = start;
    for (int i = 0; i < arr.length; i++) {
      ListNode n = new ListNode(arr[i]);
      temp.next = n;
      temp = n;
    }
    return start.next;
  }

  private static int intersetion(ListNode n1, ListNode n2) {
    int l1 = getlen(n1);
    int l2 = getlen(n2);
    if (l1 > l2) {
      int c = l1 - l2;
      while (c-- > 0) {
        n1 = n1.next;
      }
    } else if (l1 < l2){
      int c = l2 - l1;
      while (c-- > 0) {
        n2 = n2.next;
      }
    }

    while (n1 != null && n2 != null && n1.val != n2.val) {
      n1 = n1.next;
      n2 = n2.next;
    }

    if (n1 == null) {
      return -1;
    }

    return n1.val;
  }

  private static int getlen(ListNode n) {
    if (n == null) {
      return 0;
    }
    return 1  + getlen(n.next);
  }

  public static void main(String[]args) {

    int[]arr = {1,2,4,5,6,9,11,13,99,1,8,10};
    int[]brr = {3,7,8,10};
    System.out.println(intersetion(deserialize(arr), deserialize(brr)));
  }
}
