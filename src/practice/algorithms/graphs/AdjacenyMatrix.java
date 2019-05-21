package practice.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacenyMatrix {

  private static boolean isConnected(int a, int b, int n, int[][]A) {
    boolean[]visited = new boolean[n];
    return exploreAndFind(a, b, A, visited);
  }

  private static boolean exploreAndFind(int a, int b, int[][]A, boolean[]visited) {
    if (a == b) {
      return true;
    }
    visited[a] = true;
    for (int i = 0; i < A[a].length; i++) {
      if (A[a][i] == 1 && !visited[i]) {
        if (exploreAndFind(i, b, A, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private static void breadthFirstTraversal(int n, int[][]A) {
    boolean[]visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      int i = queue.remove();
      System.out.print(i + ",");
      for (int j = 0; j < A[i].length; j++) {
        if (A[i][j] == 1 && !visited[j]) {
          queue.add(j);
          visited[j] = true;
        }
      }
    }
  }

  private static void depthFirstTraversal(int n, int[][]A) {
    boolean[]visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        exploreAndPrintVertex(i, A, visited);
      }
    }
  }

  //O(V-squared)
  private static void exploreAndPrintVertex(int i, int[][]A, boolean[]visited) {
    visited[i] = true;
    System.out.print(i + ",");
    for (int l = 0; l < A[i].length; l++) {
      if (A[i][l] == 1 && !visited[l]) {
        exploreAndPrintVertex(l, A, visited);
      }
    }
  }

  //O(V-squared)
  private static void printAllDegress(int n, int[][]A) {
    for (int i = 0; i < n; i++) {
      StringBuilder strb = new StringBuilder();
      strb.append(i).append(":");
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          strb.append(j).append(",");
        }
      }
      strb.append("/");
      System.out.print(strb.toString());
    }
  }

  //O(V-squared)
  private static void printAllEdges(int n, int[][]A) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          System.out.print("(" + i + "," + j + "),");
        }
      }
    }
  }
  public static void main (String[]args) {

    int n = 5;
    int[][]A = new int[n][n];
    A[0][1] = 1;
    A[0][4] = 1;
    A[1][2] = 1;
    A[1][3] = 1;
    A[1][4] = 1;
    A[3][2] = 1;
    A[4][3] = 1;

    printAllEdges(n, A);
    System.out.println();
    printAllDegress(n, A);
    System.out.println();
    depthFirstTraversal(n, A);
    System.out.println();
    breadthFirstTraversal(n, A);
    System.out.println();
    System.out.println(isConnected(3,4, n, A));
  }
}
