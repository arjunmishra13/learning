package crackingthecodinginterview.problems;

import java.util.Arrays;

import programming.utilities.BinaryNode;

/**
 * Problem 4.3
 * @author mishra
 *
 */
public class ConvertSortedArrayIntoBalancedBinarySerachTree {

	public static BinaryNode convertToBalancedBinarySearchTree(int[]arr, int start, int end) {
		
		if(start > end) {
			return null;
		}
		int mid = start + (end - start)/2;
		BinaryNode node = new BinaryNode();
		node.setKey(arr[mid]);
		
		node.setLeftChild(convertToBalancedBinarySearchTree(arr, start, mid - 1));
		node.setRightChild(convertToBalancedBinarySearchTree(arr, mid + 1, end));
		return node;
	}
	
	public static void main(String[] args) {
		int size = 20;
		int[]arr = new int[size];
		while(size > 0) {
			size--;
			arr[size] = (int)(Math.random()*10);
		}
		
		Arrays.sort(arr);
		BinaryNode.getInOrder(convertToBalancedBinarySearchTree(arr, 0, arr.length - 1));
	}
}
