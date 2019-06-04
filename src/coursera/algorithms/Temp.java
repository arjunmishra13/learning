package coursera.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Temp {


  static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode bottom;
    public TreeNode(){};
    public TreeNode(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return Integer.toString(data);
    }

    public static void preprintelements(TreeNode n) {
      if (n == null) {
        return;
      }

      System.out.print(n.data + ",");
      preprintelements(n.left);
      preprintelements(n.right);
    }
  }

  static class Node {
    int data;
    Node left;
    Node right;
    Node next;
    Node bottom;
    public Node(){};
    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return Integer.toString(data);
    }

    public static void preprintelements(Node n) {
      if (n == null) {
        return;
      }

      System.out.print(n.data + ",");
      preprintelements(n.left);
      preprintelements(n.right);
    }
  }

  static class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }

  private static TreeNode deserializeTreeNode(Integer[]arr) {

    if (arr.length == 0 || arr[0] == null) {
      return null;
    }

    Queue<TreeNode>q = new LinkedList<>();
    int i = 0;
    TreeNode head = new TreeNode(arr[i]);
    q.add(head);
    while (!q.isEmpty()) {
      TreeNode node = q.remove();

      if (node != null) {
        if (++i < arr.length) {
          Integer val = arr[i];
          node.left = val != null? new TreeNode(val): null;
          q.add(node.left);
          if (++i < arr.length) {
            val = arr[i];
            node.right = val != null? new TreeNode(val): null;
            q.add(node.right);
          }
        }
      }
    }

    return head;
  }

  private static List<Integer> serializeTreeNode(TreeNode node) {
    List<Integer>lt = new ArrayList<Integer>();
    Queue<TreeNode>q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      TreeNode n = q.remove();
      lt.add(n != null? n.data: null);

      if (n != null) {
        q.add(n.left);
        q.add(n.right);
      }
    }

    return lt;
  }

  private static Node deserializeNode(Integer[]arr) {

    if (arr.length == 0 || arr[0] == null) {
      return null;
    }

    Queue<Node>q = new LinkedList<>();
    int i = 0;
    Node head = new Node(arr[i]);
    q.add(head);
    while (!q.isEmpty()) {
      Node node = q.remove();

      if (node != null) {
        if (++i < arr.length) {
          Integer val = arr[i];
          node.left = val != null? new Node(val): null;
          q.add(node.left);
          if (++i < arr.length) {
            val = arr[i];
            node.right = val != null? new Node(val): null;
            q.add(node.right);
          }
        }
      }
    }

    return head;
  }

  private static ListNode deserializeNodeList(Integer[]arr) {
    ListNode head = new ListNode (arr[0]);
    ListNode node  = head;
    for (int i = 1; i < arr.length; i++) {
      node.next = new ListNode(arr[i]);
      node = node.next;
    }
    return head;
  }

  private static List<Integer> serializeNodeList(ListNode n) {
    List<Integer>lt = new ArrayList<>();
    while (n != null) {
      lt.add(n.val);
      n = n.next;
    }
    return lt;
  }

  public static void main(String[]args) {
    Integer[]arr = {6,2,8,0,4,7,9,null,null,3,5};

  }
}
