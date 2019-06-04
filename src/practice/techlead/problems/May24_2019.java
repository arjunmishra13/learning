package practice.techlead.problems;

/**
 * <h>Daily Coding Problem: Problem #10 [Medium]</h>
 * <p>This problem was asked by Apple.</p>
 * <p>Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.</p>
 */
public class May24_2019 {

  private static class Scheduler <T> {
    T task;
    int n;
    Thread thread;
    Long prev = null;
    Scheduler(int n, T task) throws Exception {
      this.n = n;
      this.task = task;
      thread = new Thread((Runnable)task);
      prev = System.currentTimeMillis();
      thread.start();
    }
  }

  public static void main(String[]args) {

    int n = 5000;

    try {
      new Scheduler<Object>(n, new Runnable() {
        @Override
        public void run() {
          while (true) {
            System.out.println("Just do it...");
            try {
              Thread.sleep(n);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      });
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
