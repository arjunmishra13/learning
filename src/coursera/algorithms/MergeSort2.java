package coursera.algorithms;

public class MergeSort2 {

  public static int[] mergesort(int[]arr) {
    return mergesort(arr, 0, arr.length - 1);
  }
  private static void mergesort2(int[]arr) {
    mergesort2(arr, 0, arr.length - 1);
  }

  private static void mergesort2(int[]arr, int i, int j) {

    if (i < j) {
      int m = i + (j - i) / 2;
      mergesort2(arr, i, m);
      mergesort2(arr, m + 1, j);

      merge2(arr, i, m, j);
    }
  }

  private static int[]merge2 (int[]arr, int i, int m, int j) {
    int[]temp = new int[j - i + 1];
    int c = 0;
    int origi = i;
    int origm = m;
    int k = m + 1;
    while (c < temp.length) {
      if (i > origm) {
        temp[c++] = arr[k++];
      } else if (k > j) {
        temp[c++] = arr[i++];
      } else if (arr[i] <= arr[k]) {
        temp[c++] = arr[i++];
      } else {
        temp[c++] = arr[k++];
      }
    }

    for (int t = origi; t <= j; t++) {
      arr[t] = temp[t - origi];
    }

    return arr;
  }

  private static int[] mergesort(int[]arr, int i, int j) {
    if (i >= j) {
      return new int[]{arr[i]};
    }
    int m = i + (j  - i)/2;
    int []a = mergesort(arr, i, m);
    int []b = mergesort(arr, m + 1, j );
    return merge(a, b);
  }

  private static int[] merge(int[]arr, int[]brr) {
    int[]merge = new int[arr.length + brr.length];
    int i = 0;
    int j = 0;
    int c = 0;
    while (c < merge.length) {
      if (i >= arr.length) {
        merge[c++] = brr[j++];
      } else if (j >= brr.length) {
        merge[c++] = arr[i++];
      } else if (arr[i] <= brr[j]){
        merge[c++] = arr[i++];
      } else {
        merge[c++] = brr[j++];
      }
    }

    return merge;
  }

  public static void main(String[]args) {
    int[]arr = {4,2,3,5,2};
    for (int a: mergesort(arr)) {
      System.out.print(a + " ");
    }
    int[]brr = {4,9,3,1,1,4,6,1,6,8,9,5,3};
    System.out.println();
    mergesort2(brr);
    for (int a: brr) {
      System.out.print(a + " ");
    }
  }
}
