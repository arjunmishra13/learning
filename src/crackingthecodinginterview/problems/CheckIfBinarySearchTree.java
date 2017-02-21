package crackingthecodinginterview.problems;

import programming.utilities.BinaryNode;

/**
 * Problem 4.5
 * Solution
 * 1. In order traversale. Compare value with immediate last
 * 2. Find min max at each in order traversal. Updating the values as you descend
 * @author mishra
 *
 */
public class CheckIfBinarySearchTree {
	
	/*
	 * Min Max at each node is updated.
	 * Start with null null
	 * As you go left, your max is current, min stays same
	 * As you go right, you min is current, max stays same
	 */
	public static boolean isBinarySearchTree(BinaryNode node, Integer min, Integer max) {
		
		if(node == null) {
			return true;
		}
		
		if( (min != null && min > node.getKey()) || (max != null && max <= node.getKey()) ) {
			return false;
		}
		
		if(!isBinarySearchTree(node.getLeftChild(), min, node.getKey()) ||
				!isBinarySearchTree(node.getRightChild(), node.getKey(), max)) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Using last seen from in order traversal
	 * to compare. The next node seen,
	 * should always be greater than last node
	 * NOTE: Only works for non repeated values
	 */
	private static BinaryNode last = null;
	public static boolean isBinarySearchTreeByComparisonWithLast(BinaryNode node) {
		
		if(node == null) {
			return true;
		}
		
		if(!isBinarySearchTreeByComparisonWithLast(node.getLeftChild())) {
			return false;
		}
		
		if( last !=null && node.getKey() < last.getKey()) {
			return false;
		}
		last = node;
		
		if( !isBinarySearchTreeByComparisonWithLast(node.getRightChild())) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * I can do better
	 */
	@Deprecated
	public static boolean isBinarySearchTree(BinaryNode node) {
		
		if(node == null) {
			return true;
		}
		Integer leftMax = getMax(node.getLeftChild(), null);
		Integer rightMin = getMin(node.getRightChild(), null);
		
		boolean isSearch = true;
		if(leftMax != null) {
			if(leftMax <= node.getKey()) {
				isSearch = isSearch && isBinarySearchTree(node.getLeftChild());
			} else {
				isSearch = false;
			}
		}
		
		if(rightMin != null) {
			if(rightMin > node.getKey()) {
				isSearch = isSearch && isBinarySearchTree(node.getRightChild());
			} else {
				isSearch = false;
			}
		}
		
		return isSearch;
	}
	@Deprecated
	private static Integer getMax(BinaryNode node, Integer max) {
		
		if(node == null) {
			return max;
		}
		
		if(max == null || max < node.getKey()) {
			max = node.getKey();
		}
		
		max = getMax(node.getLeftChild(), max);
		max = getMax(node.getRightChild(), max);
		
		return max;
	}

	@Deprecated
	private static Integer getMin(BinaryNode node, Integer min) {
		
		if(node == null) {
			return min;
		}
		
		if(min == null || min > node.getKey()) {
			min = node.getKey();
		}
		
		min = getMin(node.getLeftChild(), min);
		min = getMin(node.getRightChild(), min);
		
		return min;
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
		
		node1.setRightChild(node2);
		node2.setRightChild(node3);
		node3.setRightChild(node4);
		node4.setRightChild(node5);
		node5.setRightChild(node6);
		node6.setRightChild(node7);
		node7.setRightChild(node8);
		node8.setRightChild(node9);
		node1.setRightChild(node2);
		System.out.println(isBinarySearchTreeByComparisonWithLast(node1));
		System.out.println(isBinarySearchTree(node1, null, null));
	}
}
