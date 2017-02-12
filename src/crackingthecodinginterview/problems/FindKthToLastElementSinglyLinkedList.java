package crackingthecodinginterview.problems;

import programming.utilities.DoublyListNode;

/**
 * Problem 2.2
 * @author mishra
 *
 */
public class FindKthToLastElementSinglyLinkedList {

	private static int length;
	public static DoublyListNode filterLastKElements(DoublyListNode node, int k) {
		
		int size = node == null?0:1;
		while(node.hasNext()) {
			size++;
			node = node.getNext();
		}
		
		int length = size;
		
		if( k > length ) {
			return null;
		}
		
		DoublyListNode rNode = null; 
		while(size > length - k) {
			if(rNode == null) {
				rNode = node;
			} else {
				rNode = rNode.getPrevious();
			}
			size--;
		}
		return rNode;
	}
	
	public static DoublyListNode filterLastKElementsByRecurssion(DoublyListNode node, int k, int size) {
		DoublyListNode temp = node;
		if(node != null) {
			size++;
			node = filterLastKElementsByRecurssion(node.getNext(), k, size);
		} else {
			length = size;
		}
		
		if(size > length - k) {
			return temp;
		}
		
		return node;
	}
	
	
	public static void main(String[] args) {

		DoublyListNode node1 = new DoublyListNode(1);
		DoublyListNode node2 = new DoublyListNode(2);
		DoublyListNode node3 = new DoublyListNode(3);
		DoublyListNode node4 = new DoublyListNode(4);
		DoublyListNode node5 = new DoublyListNode(5);
		DoublyListNode node6 = new DoublyListNode(6);
		DoublyListNode node7 = new DoublyListNode(7);
		DoublyListNode node8 = new DoublyListNode(8);
		DoublyListNode node9 = new DoublyListNode(9);
		DoublyListNode node10 = new DoublyListNode(10);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node2.setPrevious(node1);
		node3.setPrevious(node2);
		node4.setPrevious(node3);
		node5.setPrevious(node4);
		node6.setPrevious(node5);
		node7.setPrevious(node6);
		node8.setPrevious(node7);
		node9.setPrevious(node8);
		node10.setPrevious(node9);
		
//		System.out.println(node1 + "\t" + FindKthToLastElementSinglyLinkedList.filterLastKElements(node1, 1));
		System.out.println(node1 + "\t" + FindKthToLastElementSinglyLinkedList.filterLastKElementsByRecurssion(node1, 5, 0));
	}
}
