package practice.techlead.problems;

/**
 * <h>Daily Coding Problem: Problem #5 [Medium]</h>
 * <p>This problem was asked by Jane Street.</p>
 * <code>
 *   cons(a, b) constructs a pair, and car(pair) and cdr(pair)
 *   returns the first and last element of that pair.
 *   For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 * </code>
 * <code>
 *   Given this implementation of cons:
 *
 *    def cons(a, b):
 *     def pair(f):
 *         return f(a, b)
 *     return pair
 *
 * Implement car and cdr.
 * </code>
 */
public class May19_2019 {

  private static class Cons {
    int a;
    int b;
    Cons(int a, int b) {
      this.a = a;
      this.b = b;
    }

    Cons getPair(int a, int b) {
      return new Cons(a, b);
    }
  }

  private static class Car {
    int a;
    Car (Cons cons) {
      this.a = cons.a;
    }

    int getVal() {
      return this.a;
    }
  }

  private static class Cdr {
    int b;
    Cdr (Cons cons) {
      this.b = cons.b;
    }

    int getVal() {
      return this.b;
    }
  }


  public static void main(String[]args) {

    Cons cons = new Cons(3, 4);
    Car car = new Car(cons);
    Cdr cdr = new Cdr(cons);
    System.out.println("Car: " + car.getVal());
    System.out.println("Cdr: " + cdr.getVal());
  }
}
