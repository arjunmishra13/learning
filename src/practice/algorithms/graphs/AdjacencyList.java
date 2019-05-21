package practice.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyList {

  private static boolean hasCycles(int n, LinkedList<Integer>[]adjList) {
    boolean[]visited = new boolean[n];
    boolean[]explored = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (explore(i, adjList, visited, explored)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean explore(int i, LinkedList<Integer>[]adjList, boolean[]visited, boolean[]explored) {
    if (explored[i]) {
      return true;
    }

    if (visited[i]) {
      return false;
    }

    visited[i] = true;
    explored[i] = true;
    for (int j: adjList[i]) {
      if (explore(j, adjList, visited, explored)) {
        return true;
      }
    }

    explored[i] = false;
    return false;
  }

  //isConnected
  private static boolean isConnected(int a, int b, int n, LinkedList<Integer>[]adjList) {
    boolean[]visited = new boolean[n];
    return exploreAndFind(a, b, adjList, visited);
  }

  private static boolean exploreAndFind(int a, int b, LinkedList<Integer>[]adjList, boolean[]visited) {
    if (a == b) {
      return true;
    }

    visited[a] = true;
    for (int j: adjList[a]) {
      if (!visited[j]) {
        if (exploreAndFind(j, b, adjList, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  //Breadth first traversal O(V + E)
  private static void breadthFirstTraversal(int n, LinkedList<Integer>[]adjList) {
    boolean[]visited = new boolean[n];
    Queue<Integer>queue = new LinkedList<Integer>();
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      int i = queue.remove();
      System.out.print(i + ",");
      for (int j: adjList[i]) {
        if (!visited[j]) {
          queue.add(j);
          visited[j] = true;
        }
      }
    }
  }

  //Depth first traversal
  private static void depthFirstTraversal(int n, LinkedList<Integer>[]adjList) {
    boolean[]visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        exploreAndPrintVertex(i, adjList, visited);
      }
    }
  }

  private static void exploreAndPrintVertex(int i, LinkedList<Integer>[]adjList, boolean[]visited) {
    visited[i] = true;
    System.out.print(i + ",");
    for (int j: adjList[i]) {
      if (!visited[j]) {
        exploreAndPrintVertex(j, adjList, visited);
      }
    }
  }

  //O(Deg)
  private static void printAllDegrees(int n, LinkedList<Integer>[]adjList) {
    for (int i = 0; i < n; i++) {
      StringBuilder str = new StringBuilder();
      str.append(i).append(":");
      for (int j: adjList[i]) {
        str.append(j).append(",");
      }
      str.append("/");
      System.out.print(str.toString());
    }
  }

  //O(V + E)
  private static void printAllEdges(int n, LinkedList<Integer>[]adjList) {
    boolean[]visited = new boolean[n];
    for (int i = 0; i < n ; i++) {
      if (!visited[i]) {
        exploreAndPrintEdges(i, adjList, visited);
      }
    }
  }

  private static void exploreAndPrintEdges(int i, LinkedList<Integer>[]adjList, boolean[]visited) {
    visited[i] = true;
    for (int j: adjList[i]) {
      System.out.print("(" + i + "," + j + "),");
      if (!visited[j]) {
        exploreAndPrintEdges(j, adjList, visited);
      }
    }
  }

  public static void main(String[]args) {
    int n = 5;
    LinkedList<Integer>[]adjList = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      adjList[i] = new LinkedList<Integer>();
    }
    adjList[0].add(1);
    adjList[0].add(4);
    adjList[1].add(2);
    adjList[1].add(3);
    adjList[1].add(4);
    adjList[3].add(2);
    adjList[4].add(3);

    printAllEdges(n, adjList);
    System.out.println();
    printAllDegrees(n, adjList);
    System.out.println();
    depthFirstTraversal(n,adjList);
    System.out.println();
    breadthFirstTraversal(n, adjList);
    System.out.println("\n" + isConnected(0,3, n, adjList));
    System.out.println(hasCycles(n, adjList));
  }
}
