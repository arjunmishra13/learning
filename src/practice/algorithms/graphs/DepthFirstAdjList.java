package practice.algorithms.graphs;

import java.util.LinkedList;

public class DepthFirstAdjList {

  public static LinkedList<Integer>[] exploregraph(int n, LinkedList<Integer>[]adjlist) {

    LinkedList<Integer>[]connected = new LinkedList[n];
    for (int i  = 0; i < n; i++) {
      connected[i] = new LinkedList<Integer>();
    }

    for (int i = 0; i < n; i++) {
      boolean[]visited = new boolean[n];
      exploreGraph(i, adjlist, connected[i], visited);
    }

    return connected;
  }

  public static boolean isConnected(int n, int a, int b, LinkedList<Integer>[]adjlist) {
    boolean[]visited = new boolean[n];
    return exploreAndFind(a, b, adjlist, visited);
  }

  private static boolean exploreAndFind(int a, int b, LinkedList<Integer>[]adjlist, boolean[]visited) {

    if (a == b) {
      return true;
    }

    visited[a] = true;
    for (int i:adjlist[a]) {
      if (!visited[i]) {
        if (exploreAndFind(i, b, adjlist, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  private static int numberofislands(int n, LinkedList<Integer>[]adjlist) {
    boolean[]visited = new boolean[n];

    int c = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        explore(i, adjlist, visited);
        c++;
      }
    }

    return c;
  }

  private static void explore(int a, LinkedList<Integer>[]adjlist, boolean[]visited) {
    visited[a] = true;
    for (int i: adjlist[a]) {
      if (!visited[i]) {
        explore(i, adjlist, visited);
      }
    }
  }

  public static void exploreGraph(int a, LinkedList<Integer>[]adjlist, LinkedList<Integer>connected, boolean[]visited) {
      visited[a] = true;
      connected.add(a);
      for (int i: adjlist[a]) {
        if (!visited[i]) {
          exploreGraph(i, adjlist, connected, visited);
        }
      }
  }

  private static int numberofedges(int n, LinkedList<Integer>[]adjlist) {
    boolean[]visited = new boolean[n];
    int edges = 0;
    for (int i = 0; i < n; i++) {
      visited[i] = true;
      for (int adj: adjlist[i]) {
        if (!visited[adj]) {
          edges++;
        }
      }
    }
    return edges;
  }

  public static void main(String args[]) {
    int n = 10;
    LinkedList<Integer>[]adjlist = new LinkedList[10];
    for (int i = 0; i < n; i ++) {
      adjlist[i] = new LinkedList<Integer>();
    }
    adjlist[0].add(1);
    adjlist[0].add(3);
    adjlist[1].add(0);
    adjlist[1].add(2);
    adjlist[1].add(3);
    adjlist[2].add(1);
    adjlist[3].add(0);
    adjlist[3].add(1);

    adjlist[4].add(5);
    adjlist[5].add(4);
    adjlist[5].add(6);
    adjlist[5].add(7);
    adjlist[6].add(5);
    adjlist[6].add(7);
    adjlist[7].add(5);
    adjlist[7].add(6);

    adjlist[8].add(9);
    adjlist[8].add(8);

    LinkedList<Integer>[]c = exploregraph(n, adjlist);
    for (int i = 0; i < n; i++) {
      System.out.print(i + " - " + c[i] + ", ");
    }
    System.out.println();
    System.out.println("isConnected: " + isConnected(n, 2,8,adjlist));

    System.out.println("Edges: " + numberofedges(n, adjlist));
    System.out.println("Islands: " + numberofislands(n, adjlist));
  }

}
