package practice.techlead.problems.may;

/**
 * <h>Daily Coding Problem: Problem #3 [Medium]</h>
 * <p>This problem was asked by Google.</p>
 * <p>Given the root to a binary tree, implement serialize(root), which serializes the
 * tree into a string, and deserialize(s), which deserializes the string back into the tree.</p>
 * <p>For example, given the following Node class</p>
 * <code>
 *   class Node:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 * </code>
 * <p>The following test should pass:</p>
 * <code>
 *   node = Node('root', Node('left', Node('left.left')), Node('right'))
 *   assert deserialize(serialize(node)).left.left.val == 'left.left'
 * </code>
 */
public class May17_2019 {

  private static class Node {
    String val;
    Node left;
    Node right;
    Node (String val) {
      this.val = val;
    }

    Node (String val, Node l, Node r) {
      this.val = val;
      this.left = l;
      this.right = r;
    }
  }

  //Return pre-order traversal with markers
  private static String serializeRoot(Node root) {
    StringBuilder strb = new StringBuilder();
    getserializedString(root, strb);
    return strb.toString();
  }

  private static void getserializedString(Node root, StringBuilder strb) {
    if (root == null) {
      strb.append("-1").append(",");
      return;
    }

    strb.append(root.val).append(",");
    getserializedString(root.left, strb);
    getserializedString(root.right, strb);
  }

  static int i = 0;
  private static Node deserializeRoot(String s) {
    i = 0;
    Node root = getdeserialized(s.split(","));
    return root;
  }

  private static Node getdeserialized(String[] s) {

    if (i >= s.length || s[i].isEmpty() || s[i].equals("-1")) {
      return null;
    }

    Node n = newNode(s[i]);

    i++;
    n.left = getdeserialized(s);
    i++;
    n.right = getdeserialized(s);
    return n;
  }

  private static Node newNode(String key) {
    Node n = new Node(key);
    return n;
  }
  public static void main(String[]args) {

    Node root = new Node("root");
    Node left = new Node("left");
    Node right = new Node("right");
    Node leftleft = new Node("left.left");
    root.left = left;
    root.right = right;
    left.left = leftleft;

    System.out.println(deserializeRoot(serializeRoot(root)).left.left.val);

  }
}
