package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParanthesis {

  public static List<String> removeInvalidParentheses(String s) {
    List<String>result = new ArrayList<String>();
    if (s == null || s.length() == 0) {
      result.add("");
      return result;
    }
    //Using BFS
    LinkedList<String>q = new LinkedList<String>();
    q.addLast(s);
    Set<String>visited = new HashSet<String>();
    int iterations = 1;
    while (!q.isEmpty()) {

      //Check on each level. Each level correspond to removal of same number of characters.
      int t = 0;
      for (int j = 0; j < iterations; j++) {
        String str = q.pollFirst();
        if (!visited.contains(str)) {
          visited.add(str);
          if (isValid(str)) {
            result.add(str);
          } else {
            for (int i = 0; i < str.length(); i++) {
              char c = s.charAt(i);
              if (c == '(' || c == ')') {
                String temp = str.substring(0, i) + str.substring(i + 1);
                q.addLast(temp);
                t++;
              }
            }
          }
        }
      }
      iterations = t;

      if (!result.isEmpty()) {
        return result;
      }
    }

    return result;
  }

  private static boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int l = 0;
    int r = 0;
    for (char c: s.toCharArray()) {
      if (c == '(') {
        l++;
      } else if (c == ')') {
        r++;
      }

      if (l < r) {
        return false;
      }
    }

    return l == r;
  }

  public static void main(String[] args) {
    System.out.println(removeInvalidParentheses("()())()"));
  }
}
