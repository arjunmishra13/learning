package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<Integer, Set<String>>map = new HashMap<Integer, Set<String>>();
    Map<String, Integer>index = new HashMap<String, Integer>();
    int mini = Integer.MAX_VALUE;
    for (int i = 0; i < accounts.size(); i++) {
      int match = -1;
      map.put(i, new HashSet<String>());
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String email = accounts.get(i).get(j);
        if (!index.containsKey(email)) {
          index.put(email, i);
        } else {
          match = index.get(email);
        }
        map.get(i).add(email);
      }

      if (match != -1) {
        for (String s: map.get(i)) {
          index.put(s, match);
          map.get(match).add(s);
        }
        map.remove(i);
        mini = Math.min(mini, match);
      } else {
        mini = Math.min(mini, i);
      }
    }

    List<List<String>>lts = new ArrayList<List<String>>();
    int count = 0;
    while (count < map.keySet().size()) {
      if (map.containsKey(mini)) {
        count++;
        lts.add(new ArrayList<String>());
        int i = lts.size() - 1;
        lts.get(i).add(accounts.get(mini).get(0));
        List<String>emails = new ArrayList<String>(map.get(mini));
        Collections.sort(emails);
        lts.get(i).addAll(emails);
      }
      mini++;
    }

    return lts;
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
