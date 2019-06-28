package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class PermutationsInString {

  public static boolean checkInclusion(String s1, String s2) {
    int[]map = new int[26];
    int count = 0;
    for (char c: s1.toCharArray()) {
      map[c - 'a']++;
      count++;
    }

    int l = 0;
    int r = 0;
    while (r < s2.length()) {

      if (map[s2.charAt(r++) - 'a']-- > 0) {
        count--;
      }

      while (l < r && count == 0) {
        if (r - l == s1.length()) {
          return true;
        }

        if (map[s2.charAt(l++) - 'a']++ == 0) {
          count++;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {

    System.out.println(checkInclusion("ab","eidboaoo"));
    System.out.println(checkInclusion("adc","dcda"));
  }
}
