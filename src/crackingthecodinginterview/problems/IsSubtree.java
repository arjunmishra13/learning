package crackingthecodinginterview.problems;

import programming.utilities.BinaryNode;

/**
 * Problem 4.8
 * Good solution - In Order AND PreOrder Traversal, Then do contains on each. Also add NULL when null node is seen
 * Better Solution - What I did 
 * @author mishra
 *
 */
public class IsSubtree {
	
	/*
	 * My solution. Find the node when key is equal
	 * then check if the tree matches the other tree
	 * isSubTree O(n)
	 * treeMatch O(n)
	 * 
	 * Overall time O(n) best case
	 */
	public static boolean isSubTree(BinaryNode x, BinaryNode y) {
		
		if(x == null) {
			return false;
		}
			
		if(x.getKey() == y.getKey()) {
			//Check for tree match
			if(treeMatch(x, y)) {
				return true;
			}
		}

		return isSubTree(x.getLeftChild(), y) || isSubTree(x.getRightChild(), y);
		
	}
	
	private static boolean treeMatch(BinaryNode x, BinaryNode y) {
		if( x == null ^ y == null) {
			return false;
		} else if(x == null && y == null) {
			return true;
		}
		
		if(x.getKey() != y.getKey()) {
			return false;
		}
		
		return treeMatch(x.getLeftChild(), y.getLeftChild()) && treeMatch(x.getRightChild(), y.getRightChild());
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
		
		BinaryNode node61 = new BinaryNode(6);
		BinaryNode node71 = new BinaryNode(7);
		BinaryNode node81 = new BinaryNode(8);
		BinaryNode node91 = new BinaryNode(9);
		node81.setRightChild(node91);
		node81.setLeftChild(node71);
		node71.setLeftChild(node61);
		
		System.out.println(isSubTree(node5, node81));
	}
}
