package practice.techlead.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h>Daily Coding Problem: Problem #11 [Medium]</h>
 * <p>This problem was asked by Twitter.</p>
 * <p>Implement an autocomplete system. That is, given a query string s and a set of all possible
 * query strings, return all strings in the set that have s as a prefix.</p>
 *
 * <code>
 *   For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 *
 *   Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 * <code/>
 */
public class May25_2019 {

  private static class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    TrieNode(char c) {
      this.c = c;
      children = new HashMap<Character, TrieNode>();
    }

    boolean contains(char c) {
      return children.containsKey(c);
    }

    void addChildren(char c) {

      children.put(c, new TrieNode(c));
    }
  }

  TrieNode head = new TrieNode('0');

  public static void addString(String str) {

    for (int i = 0; i < str.length(); i++) {

    }
  }

  private static List<String> matches(String str, String[]sarr) {
    List<String> strl = new ArrayList<String>();
    for (String s: sarr) {
      if (startsWith(s.toCharArray(), str)) {
        strl.add(s);
      }
    }

    return strl;
  }

  private static boolean startsWith(char[]sarr, String prefix) {

    int i = 0;
    while (i < sarr.length) {
      if (i >= prefix.length()) {
        return true;
      }
      if (sarr[i] != prefix.charAt(i)) {
        return false;
      }
      i++;
    }

    return i >= prefix.length();
  }
  public static void main(String[]args) {

    String qstr = "do";
    String[]strarr = {"dog", "deer", "deal","dooog"};
    System.out.println(matches(qstr, strarr));
  }
}
