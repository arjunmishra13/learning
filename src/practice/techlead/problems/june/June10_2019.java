package practice.techlead.problems.june;

import java.util.LinkedList;

/**
 * <h>Daily Coding Problem: Problem #27 [Easy]</h>
 * <p>This problem was asked by Facebook.</p>
 * <p>
 *    Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 *    For example, given the string "([])[]({})", you should return true.
 *
 *    Given the string "([)]" or "((()", you should return false.
 * </p>
 */
public class June10_2019 {

  private static boolean isbalanced(String str) {

    LinkedList<Character>stack = new LinkedList<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.addLast(c);
      } else if (c == ')' && stack.peekLast() != '(') {
        return false;
      } else if (c == ']' && stack.peekLast() != '[') {
        return false;
      } else if (c == '}' && stack.peekLast() != '{') {
        return false;
      } else {
        stack.pollLast();
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[]args) {

    String str = "([])[]({})";
    System.out.println(isbalanced(str));
  }
}
