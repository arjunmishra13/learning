package crackingthecodinginterview.problems;

import java.util.*;

import programming.utilities.*;

/**
 * 4.7
 * Not necessarily binary search node
 * 
 * NOTE: If we could traverse up, we could mark the nodes 
 * as we traverse up as visited, then if 
 * node meets another visited node, we know we have found an ancestor
 * 
 * My solution - Find paths as a queue. Run time
 * 
 * Better solution
 * Check at each node, if the nodes are on the same side or no. If not, return that node, else traverse towards the direction
 * 
 * More Optimization
 * Imrpove on not calling the contains method in the previous step
 * @author mishra
 *
 */
public class FirstCommonAncestorOfTwoNodes {

	//Time O(n/2)
	public static BinaryNode getCommonAcestorCheckLeftOrRight(BinaryNode head, BinaryNode node1, BinaryNode node2) {
		
		if(head == node1 || head == node2) {
			return head;
		}
		
		boolean isNode1Left = contains(head.getLeftChild(), node1);
		boolean isNode1Right = contains(head.getLeftChild(), node2);
		
		//If they are on different sides return current node
		if( isNode1Left != isNode1Right ) {
			return head;
		}
		
		BinaryNode childNode = isNode1Left ? head.getLeftChild():head.getRightChild();
		
		return getCommonAcestorCheckLeftOrRight(childNode, node1, node2);
	}
	
	//Time O(n) since not binary search
	private static boolean contains(BinaryNode node, BinaryNode target) {
		
		if(node == null) {
			return false;
		} else if( node == target) {
			return true;
		}
		
		return contains(node.getLeftChild(), target) || contains(node.getRightChild(), target);
	}
	
	/*
	 * My solution O(n-squared)
	 */
	public static BinaryNode getFirstCommonAncestorMine(BinaryNode head, BinaryNode node1, BinaryNode node2) {
		
		Queue<BinaryNode>path1 = getPathToNode(head, node1, new LinkedList<BinaryNode>());
		Queue<BinaryNode>path2 = getPathToNode(head, node2, new LinkedList<BinaryNode>());
		
		if(path1.size() > path2.size()) {
			return getCommonAncestor(path1, path2);
		} else {
			return getCommonAncestor(path2, path1);
		}
	}
	
	//Time O(n-squared), since we dequeue 1 and then dequeue other completey
	private static BinaryNode getCommonAncestor(Queue<BinaryNode>large, Queue<BinaryNode>small) {
		
		while(!small.isEmpty()) {
			BinaryNode node = small.poll();
			Queue<BinaryNode>temp = new LinkedList<BinaryNode>(large);
			while(!temp.isEmpty()) {
				if(node == temp.poll()) {
					return node;
				}
			}
		}
		
		return null;
	}
	
	//Time - O(n) since it is not a binary search tree, we need to check every node, Space O(n)
	private static Queue<BinaryNode> getPathToNode(BinaryNode root, BinaryNode node, Queue<BinaryNode>queue) {
		
		if(root == null) {
			return queue;
		}
		
		if(root.equals(node)) {
			queue.add(root);
			return queue;
		} 
		
		queue = getPathToNode(root.getLeftChild(), node, queue);
		
		if(!queue.isEmpty()) {
			queue.add(root);
			return queue;
		}
		
		queue = getPathToNode(root.getRightChild(), node, queue);
		
		if(!queue.isEmpty()) {
			queue.add(root);
			return queue;
		}
		
		return queue;
	}
	public static void main(String[] args) {
		BinaryNode node1 = new BinaryNode(1);
		BinaryNode node2 = new BinaryNode(2);
		BinaryNode node3 = new BinaryNode(3);
		BinaryNode node4 = new BinaryNode(4);
		BinaryNode node5 = new BinaryNode(5);
		BinaryNode node6 = new BinaryNode(6);
		BinaryNode node7 = new BinaryNode(7);
		BinaryNode node8 = new BinaryNode(8);
		BinaryNode node9 = new BinaryNode(9);

		node5.setRightChild(node8);
		node8.setRightChild(node9);
		node8.setLeftChild(node7);
		node7.setLeftChild(node6);
		node5.setLeftChild(node2);
		node2.setRightChild(node4);
		node4.setLeftChild(node3);
		node2.setLeftChild(node1);
		System.out.println(getCommonAcestorCheckLeftOrRight(node5, node1, node4));
	}
}
