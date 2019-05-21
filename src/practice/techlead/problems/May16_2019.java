package practice.techlead.problems;

/**
 * May 16, 2019
 * <h>Daily Coding Problem: Problem #2 [Hard]</h>
 * <p>This problem was asked by Uber.</p>
 * <p>Given an array of integers, return a new array such that each element at index i of the new
 * array is the product of all the numbers in the original array except the one at i.</p>
 * <p>For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].</p>
 * <p>Follow-up: what if you can't use division?</p>
 */
public class May16_2019 {

  //Naive algorith. Find the total product and divide by that number
  private static int[]getpdctarraynaive (int[]arr) {
    int[]brr = new int[arr.length];

    int pdct = 1;
    for (int a: arr) {
      pdct *= a;
    }

    for (int i = 0; i < brr.length; i++) {
      brr[i] = pdct/arr[i];
    }

    return brr;
  }

  //Without division. Keep track of left products and right products
  private static int[]getpdctarraywithwoutdiv (int[]arr) {
    int[]brr = new int[arr.length];

    int[]leftp = new int[arr.length];
    int[]rightp = new int[arr.length];

    leftp[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      leftp[i] = leftp[i - 1]*arr[i];
    }

    rightp[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      rightp[i] = rightp[i + 1]*arr[i];
    }

    for (int i = 0; i < brr.length; i++) {
      if (i == 0) {
        brr[i] = rightp[i + 1];
      } else if (i == arr.length - 1){
        brr[i] = leftp[i - 1];
      } else {
        brr[i] = leftp[i - 1]*rightp[i + 1];
      }
    }

    return brr;
  }

  public static void main(String[]args) {
    int[]arr = {1,2,3,4,5};
    int[]brr = getpdctarraywithwoutdiv(arr);
    for (int i = 0; i < brr.length; i++) {
      System.out.print(brr[i] + " ");
    }
  }
}
