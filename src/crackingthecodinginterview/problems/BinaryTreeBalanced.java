package crackingthecodinginterview.problems;

import programming.utilities.BinaryNode;

/**
 * Problem 4.1
 * Every node needs to be balanced
 * Trick is to check even if one sub tree is unbalanced, 
 * to return the tree is unbalanced
 * @author mishra
 *
 */
public class BinaryTreeBalanced {

	public static boolean isBalanced(BinaryNode node) {
		
		int leftHeight = height(node.getLeftChild());
		int rightHeight = height(node.getRightChild());
		
		return Math.abs(rightHeight - leftHeight) <= 1;
	}
	
	private static int height(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return Integer.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
	}
	
	private static int intermediateHeight(BinaryNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = intermediateHeight(node.getLeftChild());
		if(leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = intermediateHeight(node.getRightChild());
		if(rightHeight == -1) {
			return -1;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		
		return Integer.max(leftHeight, rightHeight) + 1;
 	}
	
	public static boolean isBalancedImprovement(BinaryNode node) {
		
		int height = intermediateHeight(node);
		
		if(height < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		BinaryNode node1 = new BinaryNode(1);
		BinaryNode node2 = new BinaryNode(2);
		BinaryNode node3 = new BinaryNode(3);
		BinaryNode node4 = new BinaryNode(4);
		BinaryNode node5 = new BinaryNode(5);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node2.setLeftChild(node4);
		node3.setRightChild(node5);
		
		System.out.println(isBalanced(node1));
	}
}

