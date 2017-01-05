package misc.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n unique elements, and 3 hooks,
 * initially all n elements are stacked in order on hook 1.
 * Move those elements to be stacked in order on hook 3 such that
 * 1. At no time should a larger element be on top of a smaller element
 * 2. Can only add or remove an element to or from the top  
 * @author mishra
 *
 */
public abstract class TowerOfHanoi {

	List<Stack<Integer>> towers = new ArrayList<Stack<Integer>>();
	int numberOfElements;
	public TowerOfHanoi() {
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
	}
	
	public void initialize(int n) {
		this.numberOfElements = n;
		Stack<Integer>stackA = towers.get(0);
		while(n > 0) {
			stackA.push(n);
			n--;
		}
	}
	
	public String getResult() {
		Stack<Integer>stackC = towers.get(2);
		return stackC.toString();
	}
	
	public abstract void solve();
}
