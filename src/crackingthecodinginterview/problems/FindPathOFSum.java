package crackingthecodinginterview.problems;

import java.util.*;

import programming.utilities.BinaryNode;

/**
 * Problem 4.9
 * @author mishra
 *
 */
public class FindPathOFSum {
	
	
	/*
	 * My solution. Build a stack of path. 
	 * As you hit a diff of zero, add a new path, or
	 * as you hit a null node pop the existing path since it didn't add to zero, add a new path
	 * O(n)
	 * MISTAKE - Didn't consider to continue down. For example val = 5 set could be (2,3) and (2,3,-4,-2,6), but I only print (2,3)
	 */
	private static int VALUE;
	private Stack<Path>paths;
	
	enum Direction {
		LEFT, RIGTH;
	}
	
	class Path {
		List<BinaryNode>nodes;
		Path() {
			nodes = new LinkedList<BinaryNode>();
		}
		
		void addNode(BinaryNode node) {
			nodes.add(node);
		}
		
		List<BinaryNode> getNodes() {
			return nodes;
		}
		
		@Override
		public String toString() {
			return nodes.toString();
		}
	}
	
	public FindPathOFSum(int value) {
		paths = new Stack<Path>();
		paths.add(new Path());//initialize the path
		VALUE = value;
	}
	
	public void getPathOfSum(BinaryNode node) {
		
		getPath(node, VALUE, Direction.LEFT);
		paths.add(new Path());
		getPath(node, VALUE, Direction.RIGTH);
	}
	
	private void getPath(BinaryNode node, int value, Direction direction) {
		
		if(node == null) {
			if(!paths.isEmpty()) {
				paths.pop();
			}
			return;
		}
		
		int diff = value - node.getKey();
		paths.peek().addNode(node);
		
		if(diff == 0) {
			paths.add(new Path());
			diff = VALUE;
		} 
		
		if(direction == Direction.LEFT) {
			//Left paths
			getPath(node.getLeftChild(), diff, direction);
			paths.add(new Path());
			diff = VALUE;
			getPath(node.getRightChild(), diff, direction);
		} else {
			//Right paths
			getPath(node.getRightChild(), diff, direction);
			paths.add(new Path());
			diff = VALUE;
			getPath(node.getLeftChild(), diff, direction);
		}
	}
	
	public Stack<Path> getPaths() {
		return paths;
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
		
		BinaryNode node10 = new BinaryNode(5);
		BinaryNode node11 = new BinaryNode(2);
		BinaryNode node12 = new BinaryNode(-6);
		BinaryNode node13 = new BinaryNode(13);

		node5.setRightChild(node8);
		node8.setRightChild(node12);
		node8.setLeftChild(node7);
		node7.setLeftChild(node6);
		node5.setLeftChild(node2);
		node2.setRightChild(node4);
		node4.setLeftChild(node3);
		node2.setLeftChild(node10);
		node10.setLeftChild(node11);
		node12.setLeftChild(node13);
		
		int value = 7;
		FindPathOFSum find = new FindPathOFSum(value);
		find.getPathOfSum(node5);
		
		System.out.println(find.getPaths());
	}
}
