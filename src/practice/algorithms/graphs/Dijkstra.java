package practice.algorithms.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

  private static class Node {
    int vertex;
    int dist;
    Node prev;
    Node(int vertex) {
      this.vertex = vertex;
      dist = Integer.MAX_VALUE;
      prev = null;
    }
    @Override
    public String toString() {
      return vertex + "," + dist;
    }
  }

  static Comparator<Node> ndComparator = new Comparator<Node>(){
     @Override
      public int compare(Node n1, Node n2) {
       return Integer.compare(n1.dist, n2.dist);
      }
  };
  static PriorityQueue<Node> pq;
  static Map<Integer, Node> vmap;

  //O(V*Log(V))
  public static void buildHeap(int n, int s) {
    pq = new PriorityQueue<Node>(ndComparator);
    vmap = new HashMap<Integer, Node>();
    for (int i = 0; i < n; i++) {
      Node no = new Node(i);
      if (i == s) {
        no.dist = 0;
      }
      pq.add(no);
      vmap.put(i, no);
    }
  }
  public static int[] dijkstrats(int n, int[][]edges, int s) {
    int[]path = new int[n];
    while (!pq.isEmpty()) {
      Node no = pq.remove(); //O(Log(V)) for each vertex
      s = no.vertex;
      for (int i = 0; i < edges.length; i++) {
        if (edges[i][0] == s) {
          int adj = edges[i][1];
          Node nadj = vmap.get(adj);

          //O(Log(N)) for each edge
          if (nadj.dist > no.dist + edges[i][2]) {
            pq.remove(nadj);
            nadj.dist = no.dist + edges[i][2];
            nadj.prev = no;
            pq.add(nadj);
          }
        }
      }
    }

    path[s] = 0;
    for (int i = 1; i < n; i++) {
      path[i] = vmap.get(i).dist;
    }
    return path;
  }

  public static void main(String[]args) {

    int n = 5;
    int e = 6;
    //Use u,v,c as an array -> for edge u to v with cost c
    int [][]edges = new int[e][3];
    edges[0][0] = 0;
    edges[0][1] = 1;
    edges[0][2] = 15;
    edges[1][0] = 0;
    edges[1][1] = 4;
    edges[1][2] = 8;
    edges[2][0] = 0;
    edges[2][1] = 2;
    edges[2][2] = 7;
    edges[3][0] = 2;
    edges[3][1] = 3;
    edges[3][2] = 2;
    edges[4][0] = 3;
    edges[4][1] = 1;
    edges[4][2] = 3;
    edges[5][0] = 4;
    edges[5][1] = 1;
    edges[5][2] = 3;
    int s = 0;

    buildHeap(n, s);
    int []sarr = dijkstrats(n, edges, s);
    for (int i: sarr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
