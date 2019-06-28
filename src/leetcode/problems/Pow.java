package leetcode.problems;

public class Pow {

  public static double myPow(double x, int n) {
    if (n == 0 && x != 0) {
      return 1;
    }

    if (x == 0 || x == 1 || n == 1) {
      return x;
    }

    if (n == Integer.MIN_VALUE) {
      return 0;
    }

    if (n < 0) {
      return myPow(1/x, -1*n);
    }

    if (n%2 == 0) {
      double m = myPow(x*x, n/2);
      return m;
    } else {
      double m = x*myPow(x, n - 1);
      return m;
    }
  }

  public static void main(String[] args) {
    System.out.println(myPow(2.000, -123));
  }
}
