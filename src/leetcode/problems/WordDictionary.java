package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  /** Initialize your data structure here. */
  private class TrieNode  {
    Map<Character, TrieNode> map;
    Character c;
    boolean isEnd;
    TrieNode(Character c) {
      this.c = c;
      map = new HashMap<Character, TrieNode>();
    }

    boolean containsKey(Character c) {
      return map.containsKey(c);
    }

    void put(Character c, TrieNode node) {
      map.put(c, node);
    }

    TrieNode get(Character c) {
      if (!containsKey(c)) {
        return null;
      }
      return map.get(c);
    }

    boolean isEmpty() {
      return map.isEmpty();
    }
  }

  TrieNode root;
  public WordDictionary() {
    root = new TrieNode(null);
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode node = root;
    for (char c: word.toCharArray()) {
      if (!node.containsKey(c)) {
        node.put(c, new TrieNode(c));
      }
      node = node.get(c);
    }
    node.isEnd = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(TrieNode node, String word, int i) {
    if (i >= word.length()) {
      return node.isEnd;
    }
    if (node == null) {
      return false;
    }

    int j = i;
    while (j < word.length()) {
      char c = word.charAt(j);
      if (c == '.') {
        if (node.isEmpty()) {
          return false;
        }
        for (Character ch: node.map.keySet()) {
          if (search(node.get(ch), word, j + 1)) {
            return true;
          }
        }
        return false;
      } else if (!node.containsKey(c)){
        return false;
      } else {
        node = node.get(c);
        if (j == word.length() - 1) {
          return node.isEnd;
        }
      }
      j++;
    }

    return false;
  }

  public static void main(String[] args) {
    WordDictionary problem = new WordDictionary();
    problem.addWord("a");
    problem.addWord("a");
    System.out.println(problem.search("."));
    System.out.println(problem.search("a"));
    System.out.println(problem.search("aa"));
    System.out.println(problem.search("a"));
    System.out.println(problem.search(".a"));
    System.out.println(problem.search("a."));
  }
}