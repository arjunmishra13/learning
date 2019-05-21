package misc.problems;

public class FlattenList {

  static class Node {
    int data;
    Node left;
    Node right;
    Node next;
    Node bottom;

    @Override
    public String toString() {
      return Integer.toString(data);
    }
  }
  static Node flatten(Node root)
  {
    // Your code here
    Node h = root;
    Node m = root.bottom;
    while (root.next != null) {
      m = merge(m, root.next.bottom);
      root = root.next;
    }

    m = merge(m, h);
    Node t = m.next;
    h = m;
    while (t != null) {
      m.bottom = t;
      m = m.bottom;
      t = t.next;
    }
    return h;
  }
  //Merge in sorted order
  static Node merge(Node b1, Node b2) {

    if (b1 == null) {
      return b2;
    }
    if (b2 == null) {
      return b1;
    }
    if (b1.data <= b2.data) {
      b1.next = merge(b1.next, b2);
      return b1;
    } else {
      b2.next = merge(b1, b2.next);
      return b2;
    }
  }

  public static void main(String[]args) {
    Node n5 = new Node();
    n5.data = 5;
    Node n10 = new Node();
    n10.data = 10;
    Node n19 = new Node();
    n19.data = 19;
    Node n28 = new Node();
    n28.data = 28;
    Node n7 = new Node();
    n7.data = 7;
    Node n20 = new Node();
    n20.data = 20;
    Node n22 = new Node();
    n22.data = 22;
    Node n35 = new Node();
    n35.data = 35;
    Node n8 = new Node();
    n8.data = 8;
    Node n50 = new Node();
    n50.data = 50;
    Node n40 = new Node();
    n40.data = 40;
    Node n30 = new Node();
    n30.data = 30;
    Node n45 = new Node();
    n45.data = 45;

    n5.next = n10;
    n10.next = n19;
    n19.next = n28;
    n5.bottom = n7;
    n10.bottom = n20;
    n19.bottom = n22;
    n28.bottom = n35;
    n7.next = n8;
    n8.next = n30;
    n22.next = n50;
    n35.next = n40;
    n40.next = n45;
    Node n = flatten(n5);
    while (n != null) {
      System.out.print(n.data + " ");
      n = n.bottom;
    }
    System.out.println();
  }
}
