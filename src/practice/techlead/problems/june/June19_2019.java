package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #36 [Medium]</h>
 * <p>This problem was asked by Dropbox.</p>
 * <p>
 *    Given the root to a binary search tree, find the second largest node in the tree.
 * </p>
 */
public class June19_2019 {

  private static class BSTNode {
      BSTNode left;
      BSTNode right;
      int  val;
      BSTNode(int val) {
        this.val = val;
      }

      @Override
      public String toString() {
        return this.val + "";
      }
  }

  private static BSTNode deserialize(Integer[]arr) {

    LinkedList<BSTNode>q = new LinkedList<>();
    BSTNode root = null;
    int i = 0;
    if (arr[i] != null) {
      q.addLast(new BSTNode(arr[i]));
    }

    while (!q.isEmpty() && i < arr.length) {
      BSTNode node = q.pollFirst();
      if (root == null) {
        root = node;
      }
      i++;
      if (i < arr.length && arr[i] != null) {
        BSTNode left = new BSTNode(arr[i]);
        node.left = left;
        q.addLast(left);
      }
      i++;
      if (i < arr.length && arr[i] != null) {
        BSTNode right = new BSTNode(arr[i]);
        node.right = right;
        q.addLast(right);
      }
    }

    return root;
  }

  private static List<Integer> serialize(BSTNode node) {
    List<Integer>lt = new ArrayList<>();
    LinkedList<BSTNode>q = new LinkedList<>();
    if (node != null) {
      q.add(node);
    }

    while (!q.isEmpty()) {
      BSTNode n = q.remove();
      lt.add(n != null? n.val:null);
      if (n != null) {
        q.add(n.left);
        q.add(n.right);
      }
    }
    return lt;
  }

  static BSTNode largest = null;
  static BSTNode seclargest = null;
  private static BSTNode findSecondLargest(BSTNode root) {

    inorder(root);
    return seclargest;
  }

  private static void inorder(BSTNode node) {
    if (node == null) {
      return;
    }

    inorder(node.left);

    seclargest = largest;
    largest = node;

    inorder(node.right);
  }

  public static void main(String[]args) {

    Integer[]arr = {8,6,15,3,7,null,null,2,5,null,null};
    System.out.println(findSecondLargest(deserialize(arr)).val);
  }
}
