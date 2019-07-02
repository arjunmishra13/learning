package practice.techlead.problems.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <h>Daily Coding Problem: Problem #48 [Medium]</h>
 * <p>This problem was asked by Google.</p>
 * <code>
 *   Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 *
 * For example, given the following preorder traversal:
 *
 * [a, b, d, e, c, f, g]
 *
 * And the following inorder traversal:
 *
 * [d, b, e, a, f, c, g]
 *
 * You should return the following tree:
 *
 *     a
 *    / \
 *   b   c
 *  / \ / \
 * d  e f  g
 * </code>
 */
public class July1_2019 {

  private static class TreeNode {
    Character val;
    TreeNode left;
    TreeNode right;

    TreeNode(Character val) {
      this.val = val;
    }
    @Override
    public String toString() {
      return val + "";
    }
  }

  static int index;
  private static TreeNode deserialize(Character[]arr) {
    index = 0;
    if (index >= arr.length || arr[index] == null) {
      return null;
    }

    TreeNode node = new TreeNode(arr[index]);
    index++;
    node.left = deserialize(arr);
    index++;
    node.right = deserialize(arr);
    return node;
  }


  private static List<Character> serialize(TreeNode root) {
    List<Character>ser = new ArrayList<Character>();
    LinkedList<TreeNode>q = new LinkedList<TreeNode>();
    q.add(root);

    while (!q.isEmpty()) {
      int s = q.size();
      List<Character>temp = new ArrayList<>();
      boolean nochild = true;
      while (s-- > 0) {
        TreeNode node = q.pollFirst();
        if (node != null) {
          temp.add(node.val);
          q.addLast(node.left);
          q.addLast(node.right);
          nochild = false;
        } else {
          temp.add(null);
        }
      }

      if (!nochild) {
        ser.addAll(temp);
      }
    }
    return ser;
  }

  static Map<Character, Integer> indexMap;
  static int reconi;
  public static TreeNode reconstructTree(char[]preorder, char[]inorder) {
    reconi = 0;
    //build map
    indexMap = new HashMap<Character, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      indexMap.put(inorder[i], i);
    }
    return rectree(preorder, inorder, 0, inorder.length - 1);
  }

  private static TreeNode rectree(char[]preorder, char[]inorder, int s, int e) {
    if (reconi >= preorder.length || s > e) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[reconi]);
    int find = indexMap.get(preorder[reconi]);
    reconi++;
    node.left = rectree(preorder, inorder, s, find - 1);
    node.right = rectree(preorder, inorder, find + 1, e);
    return node;
  }

  public static void main(String[] args) {

    System.out.println(serialize(reconstructTree(new char[]{'a', 'b', 'd', 'e', 'c', 'f', 'g'}, new char[]{'d', 'b', 'e', 'a', 'f', 'c', 'g'})));

    System.out.println(serialize(reconstructTree(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'}, new char[]{'d', 'c', 'e', 'b', 'a', 'f', 'g'})));
  }
}
