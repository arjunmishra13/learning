package coursera.algorithms;

import java.util.ArrayList;

public class TopoSort {
  public static int[] topoSortRec(ArrayList<Integer> graph[],int N)
  {
    //add code here.
    int[]sink = new int[N];
    int sinkid = N;
    boolean[]visited =  new boolean[N];
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        sinkid = exploreAddSink(graph, i, sink, sinkid, visited);
      }
    }

    return sink;
  }

  public static int exploreAddSink(ArrayList<Integer>graph[], int s, int[]sink, int sinkid, boolean[]visited) {

    visited[s] = true;
    for (int j: graph[s]) {
      if (!visited[j]) {
        sinkid  = exploreAddSink(graph, j, sink, sinkid, visited);
      }
    }
    sink[--sinkid] = s;
    return sinkid;
  }

  public static int[] topoSortNaive(ArrayList<Integer> graph[],int N)
  {
    //add code here.
    int[]sink = new int[N];
    int sinkid = N;
    boolean[]visited =  new boolean[N];
    while (sinkid-- > 0) {
      int s = 0;
      for (int i = 0; i < N; i++) {
        if (!visited[i]) {
          s = findsink(graph, visited, i);
          visited[s] = true;
          sink[sinkid] = s;
          break;
        }
      }
    }

    return sink;
  }

  private static int findsink(ArrayList<Integer> graph[], boolean[]visited,int i) {

    for (int j: graph[i]) {
      if (!visited[j]) {
        return findsink(graph, visited, j);
      }
    }
    return i;
  }

  public static int[] topoSort(ArrayList<Integer> graph[],int N)
  {
    //add code here.
    int[]post = new int[N];
    boolean[]visited = new boolean[N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        count = explore(i, graph, post, visited, count);
      }
    }
    int[]sorted = new int[N];
    for (int i = 0; i < N; i++) {
      sorted[N - post[i]] = i;
    }

    return sorted;
  }

  public static int explore(int i, ArrayList<Integer> graph[], int[]post, boolean[]visited, int count) {

    visited[i] = true;
    for (int j: graph[i]) {
      if (!visited[j]) {
        count = explore(j, graph, post, visited, count);
      }
    }

    count++;
    post[i] = count;
    return count;
  }

  public static void printarray(int[]arr) {
    for (int a: arr) {
      System.out.print(a + ",");
    }
    System.out.println();
  }

  public static void main(String[]args) {
    int v = 6;
    ArrayList<Integer>[]adlist = new ArrayList[v];
    for (int i = 0; i < v; i++) {
      adlist[i] = new ArrayList<Integer>();
    }
//    String str = "45 16 54 29 12 41 36 13 9 31 49 52 46 53 22 4 8 11 35 19 11 54 22 47 30 37 42 53 44 47 54 28 4 47 59 19 29 35 32 39 5 23 32 51 17 55 57 25 7 31 46 18 26 8 6 57 45 50 51 30 37 47 60 43 35 59 1 4";
//    String[]strarr = str.split(" ");
//    int i = 0;
//    while (i < strarr.length) {
//      int a = Integer.parseInt(strarr[i++]);
//      int b = Integer.parseInt(strarr[i++]);
//      adlist[a].add(b);
//    }
    adlist[5].add(0);
    adlist[5].add(2);
    adlist[2].add(3);
    adlist[4].add(0);
    adlist[4].add(1);
    adlist[1].add(3);

    boolean []visited = new boolean[v];
    boolean []explored = new boolean[v];
    System.out.println("topoSort(adlist, v)");
    printarray(topoSort(adlist, v));
    System.out.println("topoSortNaive(adlist, v)");
    printarray(topoSortNaive(adlist, v));
    System.out.println("topoSortRec(adlist, v)");
    printarray(topoSortRec(adlist, v));
//    System.out.println(topoSort(adlist, v));
  }

}
