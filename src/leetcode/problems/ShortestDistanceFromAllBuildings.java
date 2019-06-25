package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShortestDistanceFromAllBuildings {

  public int shortestDistance(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][]posToDist = new int[rows][cols];
    int[][]reach = new int[rows][cols];
    List<int[]> zeros = new ArrayList<int[]>();
    //Find number of buildings
    int numberOfBuildings = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          numberOfBuildings++;
          bfs(grid, rows, cols, new int[]{i,j}, posToDist, reach);
        }
      }
    }
    Integer mind = null;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (reach[i][j] == numberOfBuildings) {
          mind = mind == null?posToDist[i][j]:Math.min(mind, posToDist[i][j]);
        }
      }
    }

    return mind == null? -1: mind;
  }

  int[][]dirs = {{-1,0},{0,-1},{0,1},{1,0}};
  private void bfs(int[][]grid, int rows, int cols, int[]point, int[][]posToDist, int[][]reach) {
    LinkedList<int[]>q = new LinkedList<int[]>();
    int[][]dist = new int[rows][cols];;
    boolean[][]visited = new boolean[rows][cols];
    boolean[][]explored = new boolean[rows][cols];

    dist[point[0]][point[1]] = 0;
    q.addLast(point);

    while (!q.isEmpty()) {
      int[]p = q.remove();
      visited[p[0]][p[1]] = true;

      for (int[]d:dirs) {
        int x = p[0] + d[0];
        int y = p[1] + d[1];

        if (isValid(x, y, grid)) {
          int[]coord = new int[]{x,y};
          if (!visited[x][y] && !explored[x][y]) {
            explored[x][y] = true;
            dist[x][y] = dist[p[0]][p[1]] + 1;
            if (grid[x][y] == 0) {
              posToDist[x][y] += dist[x][y];
              reach[x][y]++;
              q.add(coord);
            }
          }
        }
      }
    }
  }

  private boolean isValid(int x, int y, int[][]graph) {
    if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    ShortestDistanceFromAllBuildings problem = new ShortestDistanceFromAllBuildings();
    int[][]grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    System.out.println(problem.shortestDistance(grid));
  }
}
