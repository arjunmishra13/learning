package crackingthecodinginterview.problems;

import programming.utilities.BinaryNode;

public class CheckIfBinarySearchTree {

	private static boolean isBinarySearchTree(BinaryNode node) {
		
		if(node == null) {
			return true;
		}
		Integer leftMax = getMax(node.getLeftChild(), null);
		Integer rightMin = getMin(node.getRightChild(), null);
		
		boolean isSearch = true;
		if(leftMax != null && leftMax <= node.getKey()) {
			isSearch = isSearch && isBinarySearchTree(node.getLeftChild());
		}
		
		if(rightMin != null && rightMin > node.getKey()) {
			isSearch = isSearch && isBinarySearchTree(node.getRightChild());
		}
		
		return isSearch;
	}
	private static int getMax(BinaryNode node, Integer max) {
		
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

	private static int getMin(BinaryNode node, Integer min) {
		
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

		BinaryNode node = new BinaryNode();
		System.out.println(isBinarySearchTree(node));
	}
}
