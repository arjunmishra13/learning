package programming.utilities;

public class BinaryNode extends Node{
	
	public BinaryNode() {
		super();
		//Add two null nodes
		getChildren().add(null);
		getChildren().add(null);
	}
	
	public BinaryNode(int key) {
		this();
		this.setKey(key);
	}
	public BinaryNode getLeftChild() {
		return (BinaryNode)getChildren().get(0);
	}
	
	public BinaryNode getRightChild() {
		return (BinaryNode)getChildren().get(1);
	}
	
	public void setLeftChild(BinaryNode left) {
		getChildren().set(0, left);
	}

	public void setRightChild(BinaryNode right) {
		getChildren().set(1, right);
	}

	public static void getInOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		getInOrder(node.getLeftChild());
		System.out.println(node.getKey());
		getInOrder(node.getRightChild());
	}
}
