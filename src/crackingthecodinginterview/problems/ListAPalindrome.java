package crackingthecodinginterview.problems;

import programming.utilities.SinglyListNode;

public class ListAPalindrome {

	/**
	 * Problem 2.7
	 */
	
	public static SinglyListNode revNode;
	public static int listLength;
	public static boolean isPalindrome(SinglyListNode node) {
		
		if(node == null) {
			return false;
		}
		
		getReverseNode(node, 1);
		int count = 1;
		while(revNode.hasNext() && node.hasNext()) {
			if(count > listLength/2) {
				return true;
			}
			if(revNode.getKey() != node.getKey()) {
				return false;
			}
			revNode = revNode.getNext();
			node = node.getNext();
			count++;
		}
		
		return true;
	}
	
	private static SinglyListNode getReverseNode(SinglyListNode node, int numberOfNodes) {
		
		if(!node.hasNext()) {
			revNode = new SinglyListNode();
			revNode.setKey(node.getKey());
			listLength = numberOfNodes;
			return revNode;
		}
		numberOfNodes++;
		
		SinglyListNode last = getReverseNode(node.getNext(), numberOfNodes);
		SinglyListNode next = new SinglyListNode();
		next.setKey(node.getKey());
		last.setNext(next);
		
		return next;
	}
	
	public static void main(String[] args) {
		SinglyListNode node1 = new SinglyListNode(1);
		SinglyListNode node2 = new SinglyListNode(2);
		SinglyListNode node3 = new SinglyListNode(3);
		SinglyListNode node4 = new SinglyListNode(4);
		SinglyListNode node5 = new SinglyListNode(2);
		SinglyListNode node6 = new SinglyListNode(1);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		System.out.println(node1 + "\t" + ListAPalindrome.isPalindrome(node1));
	}
}
