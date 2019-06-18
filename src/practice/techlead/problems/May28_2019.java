package practice.techlead.problems;

/**
 * <h>Daily Coding Problem: Problem #14 [Medium]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *   The area of a circle is defined as πr^2.
 *   Estimate π to 3 decimal places using a aMonte Carlo method.
 *
 *   Hint: The basic equation of a circle is x2 + y2 = r2.
 * </p>
 */
public class May28_2019 {

  /**
   * pi*rsquare - area of a circle
   * 4r-square - area of square sorrounding the circle
   * Therefore area of circle is area of (pi/4)*area_of_square => pi = 4(area_of_circle/area_of_square)
   * @return
   */
  private static String valueofpi() {

    int iterations = 10000000;
    int inCircle = 0;
    for (int i = 0; i < iterations; i++) {
      if (isInCircle(random(), random())) {
        inCircle++;
      }
    }
    return String.format("%1.6f", 4*((double)inCircle/(double)iterations));
  }

  private static boolean isInCircle(double x, double y) {
    if (Math.pow(x, 2) + Math.pow(y, 2) < 1) {
      return true;
    }
    return false;
  }
  private static double random() {
    double sign = Math.random();
    if (sign >  0.5) {
      return Math.random();
    } else {
      return -1*Math.random();
    }
  }

  public static void main(String[]args) {

    System.out.println(valueofpi());
  }
}
