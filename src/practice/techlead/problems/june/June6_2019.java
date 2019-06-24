package practice.techlead.problems.june;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h>Daily Coding Problem: Problem #23 [Easy]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *     You are given an M by N matrix consisting of booleans that represents a board.
 *     Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 *
 *     Given this matrix, a start coordinate, and an end coordinate, return the minimum number
 *     of steps required to reach the end coordinate from the start. If there is no possible
 *     path, then return null. You can move up, left, down, and right. You cannot move through walls.
 *     You cannot wrap around the edges of the board.
 * </p>
 *
 * <code>
 *    For example, given the following board:
 *
 *    [[f, f, f, f],
 *    [t, t, f, t],
 *    [f, f, f, f],
 *    [f, f, f, f]]
 *    and start = (3, 0) (bottom left) and end = (0, 0) (top left),
 *    the minimum number of steps required to reach the end is 7,
 *    since we would need to go through (1, 2) because there is a wall
 *    everywhere else on the second row.
 * </code>
 */
public class June6_2019 {

  static int[][]dir = {{-1,0},{0,-1},{0,1},{1,0}};
  private static Integer steps(boolean[][]arr, int[]start, int[]end) {

    LinkedList<int[]>q = new LinkedList<>();
    Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
    int size = arr.length*arr[0].length;
    boolean[]visited = new boolean[size];
    boolean[]explored = new boolean[size];
    q.add(start);
    int startRange = start[0]*arr.length + start[1];
    int endRange = end[0]*arr.length + end[1];
    dist.put(startRange, 0);

    while (!q.isEmpty()) {
      int[]curr = q.remove();
      int currRange = curr[0]*arr.length + curr[1];
      visited[currRange] = true;

      if (currRange == endRange) {
        break;
      }

      for (int[]di: dir) {
        int x = curr[0] + di[0];
        int y = curr[1] + di[1];
        int[]coordinates = new int[]{x,y};
        int range = x*arr.length + y;
        if (isValid(x, y, arr) && !visited[range] && !explored[range] && !arr[x][y]) {
          explored[range] = true;
          q.add(coordinates);
          dist.put(range, dist.get(currRange) + 1);
        }
      }
    }
    return dist.containsKey(endRange)?dist.get(endRange):null;
  }

  private static boolean isValid(int x, int y, boolean[][]arr) {
    if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
      return false;
    }

    return true;
  }

  public static void main(String[]args) {

    boolean[][]arr = {{false, false, false, false},{true, true, false, true},{false, false, false, false},{false, false, false, false}};
    System.out.println(steps(arr, new int[]{3,0}, new int[]{0,0}));
  }
}
