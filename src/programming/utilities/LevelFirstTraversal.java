package programming.utilities;

import java.util.LinkedList;
import java.util.Queue;

public class LevelFirstTraversal extends TreeTraversal<BinaryNode>{

	/**
	 * Traverse in level first order
	 * This is breadth first traversal
	 * Ideal for BinarySearch printing
	 */
	
	Queue<BinaryNode>queue = new LinkedList<BinaryNode>();
	@Override
	public void traverse(BinaryNode node) {

		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			BinaryNode n = queue.poll();
			System.out.println(n.getKey());
			
			if(n.getLeftChild() != null) {
				queue.add(n.getLeftChild());
			}
			
			if(n.getRightChild() != null) {
				queue.add(n.getRightChild());
			}
		}
	}

}
