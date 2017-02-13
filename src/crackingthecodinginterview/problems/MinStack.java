package crackingthecodinginterview.problems;

import java.util.Stack;

/**
 * Problem 3.2
 * trick is maintain another stack for the mins so far
 * @author mishra
 *
 */
public class MinStack extends Stack<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer>min = new Stack<Integer>();
	
	public MinStack() {
		super();
	}
	public int min() {
		return min.peek();
	}
	public void push(int element) {
		
		if(min.isEmpty() || element <= min()) {
			min.push(element);
		}
		super.push(element);
	}
	
	public Integer pop() {
		int value = super.pop();
		if( value == min()) {
			min.pop();
		}
		
		return value;
	}

	
	public Integer peek() {
		return super.peek();
	}

	public static void main(String[] args) throws IndexOutOfBoundsException, Exception {
		MinStack stack = new MinStack();
		
		stack.push(7);
		stack.push(8);
		stack.pop();
		System.out.println(stack.min());
		stack.push(9);
		stack.push(6);
		stack.push(3);
		System.out.println(stack.min());
		stack.pop();
		stack.push(7);
		stack.push(7);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
