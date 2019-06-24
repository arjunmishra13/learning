package practice.techlead.problems.may;

/**
 * <h>Daily Coding Problem: Problem #6 [Hard]</h>
 * <p>This problem was asked by Google.</p>
 * <p>An XOR linked list is a more memory efficient
 * doubly linked list. Instead of each node holding
 * next and prev fields, it holds a field named both,
 * which is an XOR of the next node and the previous node.
 *
 * Implement an XOR linked list; it has an add(element) which
 * adds the element to the end, and a get(index) which returns the node at index.</p>
 */
public class May20_2019 {

  private static class XOR {
    XORNode front;
    XORNode back;
    XOR(XORNode front, XORNode back) {
      this.front = front;
      this.back = back;
    }

    XORNode getXOR(XORNode node) {
      if (node == front) {
        return back;
      } else if (node ==  back) {
        return front;
      }
      return null;
    }
  }
  private static class XORNode {
    int val;
    XOR both;

    XORNode(int val) {
      this.val = val;
    }
    @Override
    public String toString() {
      return Integer.toString(val);
    }
  }

  static XORNode head = null;
  static XORNode tail = null;
  public static void add(XORNode node) {
    if (head == null) {
      head = node;
      tail = node;
      return;
    }

    XORNode n = head;
    XORNode prev = null;
    while (n != null && n.both != null && n.both.getXOR(prev) != null) {
      XORNode temp = n;
      n = n.both.getXOR(prev);
      prev = temp;
    }

    n.both = new XOR(node, prev);
    node.both = new XOR(null, n);
    tail = node;
    return;
  }

  public static XORNode get(int i) {
    if (head == null) {
      return null;
    }

    XORNode node = head;
    XORNode prev = null;
    while (node != null && i-- > 0) {
      XORNode temp = node;
      node = node.both.getXOR(prev);
      prev = temp;
    }

    return node;
  }


  public static void main(String[]args) {
    XORNode n1 = new XORNode(1);
    XORNode n2 = new XORNode(2);
    XORNode n3 = new XORNode(3);
    XORNode n4 = new XORNode(4);
    XORNode n5 = new XORNode(5);

    System.out.println(get(0));
    add(n1);
    System.out.println(get(0));
    add(n2);
    add(n3);
    System.out.println(get(2));
    add(n4);
    add(n5);
    System.out.println(get(4));


  }
}
