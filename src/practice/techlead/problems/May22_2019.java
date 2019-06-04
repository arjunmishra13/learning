package practice.techlead.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h>Daily Coding Problem: Problem #8 [Easy]</h>
 * <p>This problem was asked by Google.</p>
 * <p>A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.</p>
 * <code>
 *   For example, the following tree has 5 unival subtrees:
 *
 *     0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 *
 * </code>
 */
public class May22_2019 {

  private static class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
      this.val = val;
    }
  }

  private static Node deserialize(Integer[]arr) {
    if (arr.length == 0) {
      return null;
    }
    Node head = new Node(arr[0]);
    int i = 0;
    Queue<Node>q = new LinkedList<>();
    q.add(head);
    while (!q.isEmpty()) {
      Node n = q.remove();
      if (n != null) {
        if (++i < arr.length) {
          n.left = arr[i] == null ? null : new Node(arr[i]);
          q.add(n.left);
        }
        if (++i < arr.length) {
          n.right = arr[i] == null ? null : new Node(arr[i]);
          q.add(n.right);
        }
      }
    }

    return head;
  }

  private static List<Integer> serialize(Node node) {
    List<Integer> lt = new ArrayList<Integer>();

    int i = 0;
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      Node n = q.remove();
      lt.add(n.val);
      if (n != null && n.left != null && n.right != null) {
        q.add(n.left);
        q.add(n.right);
      }
    }
    return lt;
  }

  static int count = 0;
  private static int countUniv(Node root) {

    traverse(root);
    return count;
  }

  private static boolean traverse(Node node) {
    if (node == null) {
      return true;
    }

    if (traverse(node.left) && traverse(node.right)) {
      if (node.left != null && node.val != node.left.val) {
        return false;
      }

      if (node.right != null && node.val != node.right.val) {
        return false;
      }
      count++;
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[]args) {
//    Integer[]arr = {0,1,0,null,null,1,0,1,1};
    Integer[]arr = {1,1,1,null,null,1,1,1,1};
    System.out.println(countUniv(deserialize(arr)));
  }
}
