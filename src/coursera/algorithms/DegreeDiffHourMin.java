package coursera.algorithms;

public class DegreeDiffHourMin {

  public static final double HOUR_FACTOR = 0.5;
  public static final double MIN_FACTOR = 6;
  public static double degreeDiff(String time) {
    String[]timearr = time.split(":");
    if (timearr.length < 2) {
      return 0.0;
    }

    int hr = 60*Integer.valueOf(timearr[0]) + Integer.valueOf(timearr[1]);
    int min = Integer.valueOf(timearr[1]);
    return Math.abs(getDegree(hr, HOUR_FACTOR)%360 - getDegree(min, MIN_FACTOR)%360);
  }

  private static double getDegree(int time, double factor) {
    return time*factor;
  }
  public static void main(String[]args) {

    System.out.println(DegreeDiffHourMin.degreeDiff("00:01"));
  }

}
