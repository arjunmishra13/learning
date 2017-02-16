package crackingthecodinginterview.problems;

import java.util.*;

import programming.utilities.Node;

public class CheckForPathInDirectedGraph {

	public static boolean isThereAroute(Node n1, Node n2) {
		if(n1 == n2) {
			return true;
		}
		Queue<Node>queue = new LinkedList<Node>();
		queue.add(n1);
		
		while(!queue.isEmpty()) {
			
			Node nodeObj = queue.poll();
			if(n2 == nodeObj) {
				return true;
			}
			for(Node n: nodeObj.getChildren()) {
				queue.add(n);
			}
		}
		
		return false;
	}
	
	/**
	 * Do depth first traversal, marking
	 * nodes as seen or not seen
	 * If every node is seen on it's path
	 * there is a path between 2 nodes
	 */
	public static void main(String[] args) {
		
		Node n1 = new Node();
		Node n2 = new Node();
		
		System.out.println(isThereAroute(n1, n2));
	}
}
