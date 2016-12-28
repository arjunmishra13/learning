package programming.utilities;

public class InOrderTreeTraversal extends TreeTraversal<BinaryNode>{

	/**
	 * Traverse in in order. Go left, print, Go right
	 * Ideal for BinarySearch printing
	 * This is depth first traversal
	 */
	@Override
	public void traverse(BinaryNode node) {
		
		if(node == null) {
			return;
		}
		//Go left
		traverse(node.getLeftChild());
		
		System.out.println(node.getKey());
		
		traverse(node.getRightChild());
	}

}
