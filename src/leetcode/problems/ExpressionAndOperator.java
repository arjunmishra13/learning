package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAndOperator {

  List<String>result = new ArrayList<String>();
  public List<String> addOperators(String num, int target) {

    dfs(num, target, 0l, 0l, 0, "");
    return result;
  }

  private void dfs(String num, int target, long val, long prev, int i, String str) {

    if (i == num.length()) {
      if (val == target) {
        result.add(str);
      }
      return;
    }

    for (int j = i; j < num.length(); j++) {
      long x = Long.valueOf(num.substring(i, j + 1));
      if (i == 0) {
        dfs(num, target, x, x, j + 1, str + x);
      } else {
        dfs(num, target, val + x, x, j + 1, str + '+' + x);
        dfs(num, target, val - x, -x, j + 1, str + '-' + x);
        dfs(num, target, val - prev + prev*x, prev*x, j + 1, str + '*' + x);
      }

      if (x == 0) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    ExpressionAndOperator exp = new ExpressionAndOperator();
    System.out.println(exp.addOperators("1231",25));
  }
}
