package crackingthecodinginterview.problems;

import java.util.Stack;

public class SortStackInAscendingOrder extends Stack<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer>bufferStack;
	public SortStackInAscendingOrder() {
		super();
		bufferStack = new Stack<Integer>();
	}
	
	public void push(int element) {
		
		loadBuffer(element);
		
		super.push(element);
		transfer();
	}
	
	public Integer pop() {
		return super.pop();
	}
	
	public Integer peek() {
		return super.peek();
	}

	private void loadBuffer(int element) {
		while(!this.empty()) {
			if(element < this.peek()) {
				bufferStack.push(this.pop());
			} else {
				break;
			}
		}
	}
	
	private void transfer() {
		
		while(!bufferStack.isEmpty()) {
			super.push(bufferStack.pop());
		}
	}
	
	public static void main(String[] args) {
		SortStackInAscendingOrder stack = new SortStackInAscendingOrder();
		
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(1);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
