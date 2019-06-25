package leetcode.problems;

public class Pow {

  public static double myPow(double x, int n) {
    if (x == 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return myPow(1/x, -1*n);
    }

    if (n%2 == 0) {
      return x*x*myPow(x, n/2);
    } else {
      return x*myPow(x, n - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(myPow(2.000, 10));
  }
}
