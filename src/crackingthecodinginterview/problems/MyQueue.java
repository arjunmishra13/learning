package crackingthecodinginterview.problems;

import java.util.Iterator;
import java.util.Stack;

public class MyQueue {

	Stack<Integer>stack1;
	Stack<Integer>stack2;
	
	public MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enqueue(int element) {
		
		//Put all elements of stack 2 into stack 1
		transfer(stack2, stack1);
		stack1.push(element);
		transfer(stack1, stack2);
	}
	
	public int dequeue() {
		return stack2.pop();
	}
	
	public int peek() {
		return stack2.peek();
	}
	
	private void transfer(Stack<Integer>s1, Stack<Integer>s2) {
		Iterator<Integer>stackItr = s1.iterator();
		while(stackItr.hasNext()) {
			s2.push(stackItr.next());
		}
	}
	
	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
	}
}
