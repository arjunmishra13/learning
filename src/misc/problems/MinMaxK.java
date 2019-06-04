package misc.problems;

/**
 * Facebook screen
 *
 * Technical Phone Screen - I
 * Subsets
 *
 * /*question:
 *
 * Input:
 *
 * Given an array A of
 * -positive
 * -sorted
 * -no duplicate
 * -integer
 *
 * A positive integer k
 *
 * Output:
 *
 * Count of all such subsets of A,
 * Such that for any such subset S,
 * Min(S) + Max(S) = k
 * subset should contain atleast two elements
 */
public class MinMaxK {

  private static int subsets(int[]arr, int k) {

    int count = 0;
    int i = 0;

    while (i < arr.length && arr[i] < k) {
      int min = arr[i];
      int j = i + 1;
      while (j < arr.length && arr[j] + min != k) {
        j++;
      }
      if (j < arr.length) {
        count += 1 + j - i > 0? (int)Math.pow(2, j - i - 1): 0;
      }
      i++;
    }

    return count;
  }

  public static void main(String[]args) {
    int[]arr = {1,2,3,4,5};
    int k = 5;
    System.out.println(subsets(arr, k));
  }
}
