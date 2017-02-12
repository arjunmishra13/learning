package crackingthecodinginterview.problems;

import programming.utilities.SinglyListNode;

public class CheckCircularLinkedList {

	/**
	 * Problem 2.6
	 * @param args
	 */
	public static boolean isCircularLinkedList(SinglyListNode node) {
		SinglyListNode runner = node.getNext().getNext();
		
		System.out.println("Node:\t" + node.getKey() + "\tRunner\t" + runner.getKey());
		while(runner != node) {
			node = node.getNext();
			runner = runner.getNext().getNext();
			System.out.println("Node:\t" + node.getKey() + "\tRunner\t" + runner.getKey());
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		SinglyListNode node1 = new SinglyListNode();
		node1.setKey(1);
		SinglyListNode node2 = new SinglyListNode();
		node2.setKey(2);
		SinglyListNode node3 = new SinglyListNode();
		node3.setKey(3);
		SinglyListNode node4 = new SinglyListNode();
		node4.setKey(4);
		SinglyListNode node5 = new SinglyListNode();
		node5.setKey(5);
		SinglyListNode node6 = new SinglyListNode();
		node6.setKey(6);
		SinglyListNode node7 = new SinglyListNode();
		node7.setKey(7);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node4);
		
		System.out.println("Is Circular\t" + isCircularLinkedList(node1));
		
	}
}
