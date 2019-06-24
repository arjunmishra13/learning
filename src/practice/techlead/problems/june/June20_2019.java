package practice.techlead.problems.june;

import java.util.ArrayList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #37 [Easy]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *    The power List of a List is the List of all its subLists. Write a function that, given a List, generates its power List.
 *
 *    For example, given the List {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 *
 *    You may also use a list or array to represent a List.
 * </p>
 */
public class June20_2019 {

  static List<List<Integer>>subLists = new ArrayList<List<Integer>>();
  private static List<List<Integer>> generateAllSubLists(List<Integer>lt) {

    generate(lt, 0, new ArrayList<Integer>());
    return subLists;
  }
  
  private static void generate(List<Integer>lt, int i, List<Integer>prev) {
    if (i > lt.size()) {
      return;
    }
    subLists.add(prev);

    for (int j = i; j < lt.size(); j++) {
      List<Integer>ltn = new ArrayList<>(prev);
      ltn.add(lt.get(j));
      generate(lt, j + 1, ltn);
    }
  }

  public static void main(String[]args) {

    List<Integer> lt = new ArrayList<Integer>();
    lt.add(1);
    lt.add(2);
    lt.add(3);
    lt.add(4);
    System.out.println(generateAllSubLists(lt).size());
    System.out.println(generateAllSubLists(lt));
  }
}
