package misc.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOfAnagrams {

  //O(NSLog(S))
  private static void printanagramswithsort(List<String>prb) {
    Map<String , List<String>>map = new HashMap<>();
    for (String s: prb) {
      char[]carr = s.toCharArray();
      Arrays.sort(carr);//O(SLog(S))
      String t = String.valueOf(carr);
      if (!map.containsKey(t)) {
        map.put(t, new ArrayList<String>());
      }
      map.get(t).add(s);
    }

    System.out.println(map.values());
  }

  private static void printAnagrams(List<String>prb) {
      if (prb.size() == 0) {
        return;
      }

      //O(N)
      int[]arr = new int[prb.size()];
      int[]rank = new int[prb.size()];
      for (int i  = 0; i < prb.size(); i++) {
        arr[i] = i;
        rank[i] = 0;
      }

      boolean[]checked = new boolean[prb.size()];
      //O(NS)
      for (int i = 0; i < prb.size(); i++) {
        if (!checked[i]) {
          checked[i] = true;
          for (int j = i + 1; j < prb.size(); j++) {
            if (!checked[j] && isAnagram(prb.get(i), prb.get(j))) {
              //union
              union(arr, rank, i, j);
              checked[j] = true;
            }
          }
        }
      }

      Map<Integer, List<String>>out = new HashMap<Integer, List<String>>();
      for (int i = 0; i < arr.length; i++) {
        if (!out.containsKey(arr[i])) {
          out.put(arr[i], new ArrayList<String>());
        }
        out.get(arr[i]).add(prb.get(i));
      }

      System.out.println(out.values());
  }

  private static void union(int[]arr, int[]rank, int i, int j) {
    if (rank[i] >= rank[j]) {
      int pi = find(arr, i);
      arr[j] = pi;
      if (rank[i] == rank[j]) {
        rank[i] = rank[i] + 1;
      }
    } else {
      int pj = find(arr, j);
      arr[i] = pj;
    }
  }

  private static int find(int[]arr, int i) {
    if (arr[i] == i) {
      return i;
    }

    arr[i] = find(arr, arr[i]);
    return arr[i];
  }

  //O(S)
  private static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Map<Character, Integer> cmap = new HashMap<Character, Integer>();
    for (int i = 0; i < s1.length(); i++) {
      if (!cmap.containsKey(s1.charAt(i))) {
        cmap.put(s1.charAt(i), 0);
      }
      cmap.put(s1.charAt(i), cmap.get(s1.charAt(i)) + 1);
    }

    for (int i = 0; i < s2.length(); i++) {
      char s = s2.charAt(i);
      if (!cmap.containsKey(s)) {
        return false;
      }
      cmap.put(s, cmap.get(s) - 1);
      if (cmap.get(s) <= 0) {
        cmap.remove(s);
      }
    }

    return true;
  }

  public static void main(String[]args) {
    List<String> prb = new ArrayList<String>();
    prb.add("star");
    prb.add("rats");
    prb.add("car");
    prb.add("arc");
    prb.add("arts");
    prb.add("stars");
    prb.add("lame");
    prb.add("male");
    prb.add("meal");
    prb.add("meal");
    prb.add("meal");
    prb.add("meal");
    prb.add("meal");
    prb.add("meal");
    prb.add("males");

    printAnagrams(prb);
    printanagramswithsort(prb);
  }
}
