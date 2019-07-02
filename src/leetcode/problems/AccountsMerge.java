package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AccountsMerge {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    DisjointSet disj = new DisjointSet(accounts.size());
    Map<String, Integer>map = new TreeMap<String, Integer>();
    for (int i = 0; i < accounts.size(); i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String email = accounts.get(i).get(j);
        if (!map.containsKey(email)) {
          map.put(email, i);
        } else {
          disj.merge(map.get(email), i);
        }
      }
    }

    Map<Integer, List<String>>resm = new HashMap<Integer, List<String>>();
    for (String email: map.keySet()) {
      int index = disj.find(map.get(email));
      if (!resm.containsKey(index)) {
        resm.put(index, new ArrayList<String>());
      }
      if (resm.get(index).isEmpty()) {
        resm.get(index).add(accounts.get(index).get(0));
      }

      resm.get(index).add(email);
    }

    return new ArrayList(resm.values());
  }

  private void update(Map<String, Integer>map, List<String>lt, int index) {
    for (int i = 1; i < lt.size(); i++) {
      map.put(lt.get(i), index);
    }
  }

  private class DisjointSet {
    int[]parent;
    int[]rank;
    DisjointSet(int n) {
      parent = new int[n];
      rank = new int[n];

      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int i) {
      if (parent[i] == i) {
        return i;
      }
      parent[i] = find(parent[i]);
      return parent[i];
    }

    void merge(int i, int j) {
      int fi = find(i);
      int fj = find(j);

      int ri = rank[fi];
      int rj = rank[fj];

      if (ri > rj) {
        parent[fj] = fi;
      } else if (ri < rj) {
        parent[fi] = fj;
      } else {
        parent[fj] = fi;
        rank[fj]++;
      }
    }
  }

  public static void main(String[] args) {
    AccountsMerge problem = new AccountsMerge();
    List<List<String>>lts = Arrays.asList(
        Arrays.asList("David","David0@m.co","David1@m.co"),
        Arrays.asList("David","David3@m.co","David4@m.co"),
        Arrays.asList("David","David4@m.co","David5@m.co"),
        Arrays.asList("David","David2@m.co","David3@m.co"),
        Arrays.asList("David","David1@m.co","David2@m.co"));
    System.out.println(problem.accountsMerge(lts));
  }
}
