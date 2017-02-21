package crackingthecodinginterview.problems;

import programming.utilities.BinaryNodeWithParent;

/**
 * Problem 4.6
 * Find the in order successor of a binary node
 * @author mishra
 *
 */
public class FindNextNode {

	public static BinaryNodeWithParent getNextNode(BinaryNodeWithParent node) {
		
		if(node == null) {
			return null;
		}
		
		if(node.getRightChild() != null) {
			return getLeftMostNode(node.getRightChild());
		}
		return getFirstGreaterParent(node);
	}
	
	private static BinaryNodeWithParent getFirstGreaterParent(BinaryNodeWithParent node) {
		
		if(node == null ) {
			return null;
		}
		
		if(node.getParent() == null) {
			return null;
		}
		
		if( node.getParent().getKey() >= node.getKey()) {
			return node.getParent();
		}
		
		return getFirstGreaterParent(node.getParent());
	}
	
	private static BinaryNodeWithParent getLeftMostNode(BinaryNodeWithParent node) {
		
		if(node == null) {
			return null;
		}
		
		if(node.getLeftChild() == null) {
			return node;
		}
		
		return getLeftMostNode(node.getLeftChild());
	}
	
	public static void main(String[] args) {
		BinaryNodeWithParent node1 = new BinaryNodeWithParent(1);
		BinaryNodeWithParent node2 = new BinaryNodeWithParent(2);
		BinaryNodeWithParent node3 = new BinaryNodeWithParent(3);
		BinaryNodeWithParent node4 = new BinaryNodeWithParent(4);
		BinaryNodeWithParent node5 = new BinaryNodeWithParent(5);
		BinaryNodeWithParent node6 = new BinaryNodeWithParent(6);
		BinaryNodeWithParent node7 = new BinaryNodeWithParent(7);
		BinaryNodeWithParent node8 = new BinaryNodeWithParent(8);
		BinaryNodeWithParent node9 = new BinaryNodeWithParent(9);
		
		node5.setRightChild(node8);
		node8.setRightChild(node9);
		node8.setLeftChild(node7);
		node7.setLeftChild(node6);
		node5.setLeftChild(node2);
		node2.setRightChild(node4);
		node4.setLeftChild(node3);
		node2.setLeftChild(node1);
		if(CheckIfBinarySearchTree.isBinarySearchTree(node5, null, null)) {
			BinaryNodeWithParent next = getNextNode(node4);
			System.out.println(next != null?next.getKey():"Next is null");
		} else {
			System.out.println("Not a binary tree");
		}
	}
}
