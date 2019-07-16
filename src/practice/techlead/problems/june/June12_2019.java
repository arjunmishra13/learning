package practice.techlead.problems.june;

import java.util.LinkedList;

/**
 * <h>Daily Coding Problem: Problem #29 [Easy]</h>
 * <p>This problem was asked by Amazon.</p>
 * <p>
 *    Run-length encoding is a fast and simple method of encoding strings.
 *    The basic idea is to represent repeated successive characters as a single count and character.
 *    For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 *
 *    Implement run-length encoding and decoding. You can assume the string to be encoded have no digits
 *    and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 * </p>
 */
public class June12_2019 {

  private static String encoding(String str) {

    StringBuilder strb = new StringBuilder();
    int i = 0;
    while (i < str.length()) {
      int count = 0;
      char c = str.charAt(i);
      while (i < str.length() && str.charAt(i) == c) {
        i++;
        count++;
      }
      strb.append(count).append(c);
    }

    return strb.toString();
  }

  public static void main(String[]args) {

    System.out.println(encoding("AAAABBBCCDAA"));
    System.out.println(encoding("ABCD"));
  }
}
