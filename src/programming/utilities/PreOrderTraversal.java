package programming.utilities;

public class PreOrderTraversal extends TreeTraversal<BinaryNode>{

	/**
	 * Traverse in pre order. Print, Go left, then Go right
	 * This is depth first traversal
	 */
	@Override
	public void traverse(BinaryNode node) {
		
		if(node == null) {
			return;
		}
		System.out.println(node.getKey());

		//Go left
		traverse(node.getLeftChild());
		
		//Go right
		traverse(node.getRightChild());
	}

}
