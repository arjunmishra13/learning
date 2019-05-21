package misc.problems;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeGivenPrePostIn {

  public static class TreeNode {

    private int key;
    ArrayList<TreeNode> children;

    public TreeNode (int key) {
      this.key = key;
      children = new ArrayList<TreeNode>();
    }

    public int getKey() {
      return key;
    }
    public List<TreeNode> getChildren() {
      return children;
    }
    public void addChildren(TreeNode n) {
      children.add(n);
    }
    @Override
    public String toString() {
      return Integer.toString(key);
    }

  }

  static class Node {
    int data;
    Node left;
    Node right;
    Node next;
    Node bottom;
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

  private static String getarrstr(int[]arr) {
    StringBuilder strb = new StringBuilder();
    for (int a: arr) {
      strb.append(a).append(",");
    }
    return strb.toString();
  }
  static int cursor = 0;
  public static Node buildTreeGivenPost(int[] inorder, int[] postorder) {

    cursor = postorder.length - 1;
    Node n = buildForPost(inorder, 0, inorder.length - 1, postorder);
    return n;
  }

  public static Node buildTreeGivenPre(int[] inorder, int[] postorder) {

    cursor = 0;
    Node n = buildForPre(inorder, 0, inorder.length - 1, postorder);
    return n;
  }

  public static Node buildForPost(int[]inorder, int is, int il, int[]postorder) {
    if (is > il) {
      return null;
    }
    System.out.println(getarrstr(postorder) + ": " + is + "," + il + "," + cursor);
    Node n = new Node(postorder[cursor]);
    int index = findIndex(inorder, postorder[cursor]);
    cursor--;

    n.right = buildForPost(inorder, index + 1, il, postorder);
    n.left = buildForPost(inorder, is, index - 1, postorder);

    return n;
  }

  public static Node buildForPre(int[]inorder, int is, int il, int[]preorder) {
    if (is > il) {
      return null;
    }

    System.out.println(getarrstr(preorder) + ": " + is + "," + il + "," + cursor);
    Node n = new Node(preorder[cursor]);
    int index = findIndex(inorder, preorder[cursor]);
    cursor++;

    n.left = buildForPre(inorder, is, index - 1, preorder);
    n.right = buildForPre(inorder, index + 1, il, preorder);
    return n;
  }

  public static int findIndex(int[]inorder, int k) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == k) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[]args) {
    int[]in = {4,2,5,1,8,6,3,7,9};
    int[]post = {4,5,2,8,6,9,7,3,1};
    int[]pre = {1,2,4,5,3,6,8,7,9};
    Node n = buildTreeGivenPost(in, post);
    Node.preprintelements(n);
    System.out.println();
    Node m = buildTreeGivenPre(in, pre);
    Node.preprintelements(m);
  }
}
