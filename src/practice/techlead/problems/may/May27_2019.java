package practice.techlead.problems.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <h>Daily Coding Problem: Problem #13 [Hard]</h>
 * <p>This problem was asked by Amazon.</p>
 * <p>
 *   Given an integer k and a string s, find the length of the
 *   longest substring that contains at most k distinct characters.
 * </p>
 * <code>
 *   For example, given s = "abcba" and k = 2,
 *   the longest substring with k distinct characters is "bcb".
 * </code>
 */
public class May27_2019 {

  private static int lenofLongestStrWithKDistincChars(String str, int k) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int count = 0;
    int s = 0;
    int i = 0;
    while (i < str.length()) {
      char c = str.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 0);
        count++;
      }
      map.put(c, map.get(c) + 1);
      if (count > k) {
        max = Integer.max(max, i - s);

        while (s < i) {
          map.put(str.charAt(s), map.get(str.charAt(s)) - 1);
          if (map.get(str.charAt(s)) == 0) {
            map.remove(str.charAt(s));
            count--;
            s++;
            break;
          }
          s++;
        }
      }
      i++;
    }

    if (count == k) {
      max = Integer.max(max, i - s);
    }

    return max;
  }

  public static void main(String[]args) {

    int k = 2;
    String str = "aabaccaaaddccccccccca";
    System.out.println(lenofLongestStrWithKDistincChars(str, k));
  }
}
