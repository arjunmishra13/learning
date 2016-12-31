package misc.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import programming.utilities.Node;
import programming.utilities.TreeTraversal;

public class ZigZagTreeTraversals extends TreeTraversal<Node>{

	/**
	 * Traverse tree in left to right, then right to left and so on
	 * Trick is to keep track of all children at a level
	 */

	private Queue<Node> queue = new LinkedList<Node>();
	
	@Override
	public void traverse(Node node) {
		//Maintain a queue of all nodes
		queue.add(node);
		//Keep track of number of nodes at a level, initialize to 1
		int levelNodes = 1;
		//Keep track of the direction, alternates at every level
		boolean direction = true;
		while(!queue.isEmpty()) {
			int tempLevel = 0;
			Stack<Node> reverseOrder = new Stack<Node>();
			for(int count = 0; count<levelNodes; count++) {
				Node current = queue.poll();
				if(direction) {
					System.out.println(current.getKey());
				} else {
					reverseOrder.push(current);
				}
				for(Node kid: current.getChildren()) {
					queue.add(kid);
					tempLevel++;
				}
			}
			while(!reverseOrder.isEmpty()) {
				System.out.println(reverseOrder.pop().getKey());
			}
			levelNodes = tempLevel;
			direction = !direction;
		}
	}
	
	/* Base Tree (As a Binary Max Heap)
	 * 								15
	 * 				7								14			
	 * 		5				6				12				13	
	 * 	1		2		3		4		11		9		10		8			
	 */
	
	public static Node buildTree1(Node root) {
		
		/* Base Tree (As a Binary Max Heap)
		 * 								15
		 * 				7								14			
		 * 		5				6				12				13	
		 * 					3		4				9							
		 */
		Node n7 = new Node();
		n7.setKey(7);
		Node n14 = new Node();
		n14.setKey(14);
		Node n5 = new Node();
		n5.setKey(5);
		Node n6 = new Node();
		n6.setKey(6);
		Node n12 = new Node();
		n12.setKey(12);
		Node n13 = new Node();
		n13.setKey(13);
		Node n3 = new Node();
		n3.setKey(3);
		Node n4 = new Node();
		n4.setKey(4);
		Node n9 = new Node();
		n9.setKey(9);
		
		root.addChildren(n7);
		root.addChildren(n14);
		
		n7.addChildren(n5);
		n7.addChildren(n6);
		
		n14.addChildren(n12);
		n14.addChildren(n13);
		
		n6.addChildren(n3);
		n6.addChildren(n4);
		
		n12.addChildren(n9);
		return root;
	}
	public static void main(String[] args) {
		ZigZagTreeTraversals zigzag = new ZigZagTreeTraversals();
		
		Node root = new Node();
		root.setKey(15);
		root = buildTree1(root);
		
		zigzag.traverse(root);
	}
}
