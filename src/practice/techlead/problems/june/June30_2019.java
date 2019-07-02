package practice.techlead.problems.june;

public class June30_2019 {

  /**
   * <h>Daily Coding Problem: Problem #47 [Easy]</h>
   * <p>This problem was asked by Facebook.</p>
   * <code>
   *   Given a array of numbers representing the stock prices of a company in chronological order,
   *   write a function that calculates the maximum profit you could have made from buying and
   *   selling that stock once. You must buy before you can sell it.
   *
   *   For example, given [9, 11, 8, 5, 7, 10], you should return 5,
   *   since you could buy the stock at 5 dollars and sell it at 10 dollars.
   * </code>
   */

  public static int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int max = 0;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (min > prices[i]) {
        min = prices[i];
        max = 0;
      } else if (max < prices[i]) {
        max = prices[i];
      }

      profit = Math.max(profit, max - min);
    }

    return Math.max(profit, max - min);
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{9, 11, 8, 5, 7, 10}));
  }
}
