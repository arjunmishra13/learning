package practice.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstEdgeList {

  private static Map<Integer, List<Integer>> exploregraph (int n, List<List<Integer>>edgelist) {
    Map<Integer, List<Integer>>c = new HashMap<Integer, List<Integer>>();

    for (int i = 0; i < n; i++) {
      boolean[] visited = new boolean[n];
      c.put(i, new ArrayList<Integer>());
      exploreall(i, edgelist, c.get(i), visited);
    }
    return c;
  }

  private static void exploreall(int a, List<List<Integer>>edgelist, List<Integer>c, boolean[]visited) {
    visited[a] = true;
    c.add(a);

    for (List<Integer>edge: edgelist) {
      int v1 = edge.get(0);
      int v2 = edge.get(1);

      if (v1 == a) {
        if (!visited[v2]) {
          exploreall(v2, edgelist, c, visited);
        }
      } else if (v2 == a){
        if (!visited[v1]) {
          exploreall(v1, edgelist, c, visited);
        }
      }
    }
  }

  private static boolean isConnected (int n, int a, int b, List<List<Integer>>edgelist) {
    boolean[]visited = new boolean[n];
    return exploreAndFind(a, b, edgelist, visited);
  }

  private static boolean exploreAndFind(int a, int b, List<List<Integer>>edgelist, boolean[]visited) {
    if (a == b) {
      return true;
    }
    visited[a] = true;

    for (List<Integer>edge: edgelist) {
      int v1 = edge.get(0);
      int v2 = edge.get(1);

      if (v1 == a && !visited[v2]) {
        if (exploreAndFind(v2, b, edgelist, visited)) {
          return true;
        }
      } else if (v2 == a && !visited[v1]) {
        if (exploreAndFind(v1, b, edgelist, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  private static int numberofislands(int n, List<List<Integer>>edgelist) {
    boolean []visited = new boolean[n];
    int c = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        explore(i, edgelist, visited);
        c++;
      }
    }
    return c;
  }

  private static void explore(int a, List<List<Integer>>edgelist, boolean[]visited) {
    visited[a] = true;
    for (List<Integer>edge: edgelist) {
      int v1 = edge.get(0);
      int v2 = edge.get(1);
      if (v1 == a && !visited[v2]) {
        explore(v2, edgelist, visited);
      } else if (v2 == a && !visited[v1]) {
        explore(v1, edgelist, visited);
      }
    }
  }

  public static void main(String args[]) {
    int n = 10;//number of vertices
    List<List<Integer>> edgelist = new ArrayList<List<Integer>>();
    List<Integer>e1 = new ArrayList<Integer>();
    List<Integer>e2 = new ArrayList<Integer>();
    List<Integer>e3 = new ArrayList<Integer>();
    List<Integer>e4 = new ArrayList<Integer>();
    List<Integer>e5 = new ArrayList<Integer>();
    List<Integer>e6 = new ArrayList<Integer>();
    List<Integer>e7 = new ArrayList<Integer>();
    List<Integer>e8 = new ArrayList<Integer>();
    List<Integer>e9 = new ArrayList<Integer>();
    edgelist.add(e1);
    edgelist.add(e2);
    edgelist.add(e3);
    edgelist.add(e4);
    edgelist.add(e5);
    edgelist.add(e6);
    edgelist.add(e7);
    edgelist.add(e8);
    edgelist.add(e9);

    e1.add(0);e1.add(1);
    e2.add(1);e2.add(2);
    e3.add(3);e3.add(1);
    e4.add(3);e4.add(0);
    e5.add(4);e5.add(5);
    e6.add(5);e6.add(7);
    e7.add(6);e7.add(5);
    e8.add(6);e8.add(7);
    e9.add(8);e9.add(9);

    Map<Integer, List<Integer>>c = exploregraph(n, edgelist);
    for (int i = 0; i < n; i++) {
      System.out.print(i + " - " + c.get(i) + ", ");
    }
    System.out.println();
    System.out.println("isConnected: " + isConnected(n, 4, 7, edgelist));

    System.out.println("Edges: " + edgelist.size());
    System.out.println("Islands: " + numberofislands(n, edgelist));
  }
}
