package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #24 [Medium]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *    Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
 *
 *    Design a binary tree node class with the following methods:
 *
 *    is_locked, which returns whether the node is locked
 *    lock, which attempts to lock the node. If it cannot be locked, then it should return false.
 *    Otherwise, it should lock it and return true.
 *    unlock, which unlocks the node. If it cannot be unlocked, then it should return false.
 *    Otherwise, it should unlock it and return true.
 *    You may augment the node to add parent pointers or any other property you would like.
 *    You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 *    Each method should run in O(h), where h is the height of the tree.
 * </p>
 */
public class June7_2019 {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    boolean isLocked;

    TreeNode (int val) {
      this.val = val;
    }

    public boolean isLocked(TreeNode node) {
      return node.isLocked;
    }

    public boolean lock(TreeNode node) {
      return false;
    }
  }

  private static TreeNode deserialize(Integer[]arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) {
      return null;
    }

    TreeNode root = new TreeNode(arr[0]);
    LinkedList<TreeNode>q =  new LinkedList<>();
    if (root != null) {
      q.addLast(root);
    }

    int i = 1;
    while (i < arr.length && !q.isEmpty()) {
      TreeNode node = q.pollFirst();
      TreeNode left = arr[i] == null?null:new TreeNode(arr[i]);
      i++;
      TreeNode right = arr[i] == null?null:new TreeNode(arr[i]);
      i++;
      node.left = left;
      node.right = right;
      if (left != null) {
        left.parent = node;
        q.addLast(left);
      }

      if (right != null) {
        right.parent = node;
        q.addLast(right);
      }
    }

    return root;
  }

  private static List<Integer> serialize(TreeNode node) {
    List<Integer>lt = new ArrayList<Integer>();
    if (node == null) {
      return lt;
    }

    LinkedList<TreeNode>q =  new LinkedList<>();
    if (node != null) {
      q.addLast(node);
    }

    while (!q.isEmpty()) {
      TreeNode n = q.pollFirst();
      lt.add(n == null?null:n.val);
      if (n != null) {
        q.addLast(n.left);
        q.addLast(n.right);
      }
    }

    return lt;
  }

  public static TreeNode curr;

  public static void main(String[]args) {

    Integer[]arr = {};
    TreeNode curr = deserialize(arr);
  }
}
