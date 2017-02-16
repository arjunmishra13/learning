package crackingthecodinginterview.problems;

import java.util.*;

import programming.utilities.BinaryNode;
import programming.utilities.Node;

public class CreateALinkedListOfAllNodesAtEachDepth {

/**
 * Problem 3.4 
 */
	public static Set<List<BinaryNode>> createLinkedListAtEachDepth(BinaryNode node) {
		Set<List<BinaryNode>>allLists = new HashSet<List<BinaryNode>>();
		Queue<BinaryNode>queue = new LinkedList<BinaryNode>();
		queue.add(node);
		int numberOfChildren = 0;
		while(!queue.isEmpty()) {
			
			int temp = 0;
			List<BinaryNode>list = new LinkedList<BinaryNode>();
			while(numberOfChildren > 0) {
				BinaryNode n = queue.poll(); 
				list.add(n);
				numberOfChildren--;
				
				for(Node child:n.getChildren()) {
					queue.add((BinaryNode)child);
					temp++;
				}
			}
			
			if(!list.isEmpty()) {
				allLists.add(list);
			}
			numberOfChildren = temp;
		}
		return allLists;
	}
	
	public static void main(String[] args) {
		BinaryNode node = new BinaryNode();
	}
}
