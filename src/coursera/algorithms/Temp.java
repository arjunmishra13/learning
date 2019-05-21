package coursera.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Temp {


  public static class TreeNode {

    private int key;
    ArrayList<TreeNode>children;

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

  public static int numIslands(char[][] grid) {
    boolean[][]visited = new boolean[grid.length][grid[0].length];
    int c = 0;
    int[][]check = {{-1,0},{0,-1},{0,1},{1,0}};
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] != 0) {
          explore(grid, i, j, visited, check);
          c++;
        }
      }
    }

    return c;
  }

  private static void explore(char[][]grid, int i, int j, boolean[][]visited, int[][]check) {
    visited[i][j] = true;

    for (int[]c: check) {
      int x = i + c[0];
      int y = j + c[1];
      if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
        if (!visited[x][y] && grid[x][y] != 0) {
          explore(grid, x, y, visited, check);
        }
      }
    }
  }

  public static void main(String[]args) {
    int[][]arr = {{1,2},{2,3},{3,4}};
    char[][]carr = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

    System.out.println(numIslands(carr));
  }

//  public static void main(String[]args) {
//
//    Node n0 = new Node();
//    n0.data = 0;
//    Node n1 = new Node();
//    n1.data = 1;
//    Node n2 = new Node();
//    n2.data = 2;
//    Node n3 = new Node();
//    n3.data = 3;
//    Node n4 = new Node();
//    n4.data = 4;
//    Node n5 = new Node();
//    n5.data = 5;
//    Node n6 = new Node();
//    n6.data = 6;
//    Node n7 = new Node();
//    n7.data = 7;
//    Node n8 = new Node();
//    n8.data = 8;
//    Node n9 = new Node();
//    n9.data = 9;
//    Node n10 = new Node();
//    n10.data = 10;
//    Node n20 = new Node();
//    n20.data = 20;
//    Node n15 = new Node();
//    n15.data = 15;
//    Node n50 = new Node();
//    n50.data = 50;
//
//    n10.left = n5;
//    n10.right = n15;
//    n15.left = n6;
//    n15.right = n20;
//    System.out.println();
////    while ( n1 != null) {
////      System.out.print(n1.data + " ");
////      n1 = n1.next;
////    }
////    for(int a: arr) {
////      System.out.print(a + ",");
////    }
//  }
}
