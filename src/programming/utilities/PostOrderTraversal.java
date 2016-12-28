package programming.utilities;

public class PostOrderTraversal extends TreeTraversal<BinaryNode>{

	/**
	 * Traverse in post order. Go left, Go right, then print
	 * This is depth first traversal
	 */
	@Override
	public void traverse(BinaryNode node) {
		
		if(node == null) {
			return;
		}

		//Go left
		traverse(node.getLeftChild());
		
		//Go right
		traverse(node.getRightChild());

		System.out.println(node.getKey());
	}

}
