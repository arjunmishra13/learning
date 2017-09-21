package misc.concepts;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Written by Misha with SENTRY-1909 to demonstrate
 * changing Sets to Collections (so we can use ArrayLists)
 * will improve performance
 */

public class SetListMemoryComparison {

  public static final int NUM_OBJS = 1000 * 1000;
  public static final int NUM_STRS = 30;
  public static final String[] STRINGS = new String[NUM_STRS];

  public static void main(String args[]) {
    // Fill the strings array once
    for (int i = 0; i < NUM_STRS; i++) {
      STRINGS[i] = Integer.toString(i);
    }

    Object[] listsOrSets = new Object[NUM_OBJS];

    System.gc();

    for (int i = 0; i < NUM_OBJS; i++) {
      HashSet<String> set = new HashSet<>(NUM_STRS);
      for (int j = 0; j < NUM_STRS; j++) {
        set.add(STRINGS[j]);
      }
      listsOrSets[i] = set;
    }

    reportMemory("sets");

    System.gc();

    for (int i = 0; i < NUM_OBJS; i++) {
      ArrayList<String> list = new ArrayList<>(NUM_STRS);
      for (int j = 0; j < NUM_STRS; j++) {
        list.add(STRINGS[j]);
      }
      listsOrSets[i] = list;
    }

    reportMemory("lists");

  }

  private static void reportMemory(String s) {
    System.gc();
    Runtime r = Runtime.getRuntime();
    long usedMemInMB = (r.totalMemory() - r.freeMemory()) / 1024 / 1024;
    System.out.println("Used memory by  " + s + ": " + usedMemInMB + " MB");
  }
}
