package programming.utilities;

public class BinaryNodeWithParent extends BinaryNode {

	BinaryNodeWithParent parent;
	public BinaryNodeWithParent() {
		super();
	}
	
	public BinaryNodeWithParent(int key) {
		super(key);
	}
	
	public void setLeftChild(BinaryNodeWithParent left) {
		getChildren().set(0, left);
		left.setParent(this);
	}

	public void setRightChild(BinaryNodeWithParent right) {
		getChildren().set(1, right);
		right.setParent(this);
	}
	
	public void setParent(BinaryNodeWithParent parent) {
		this.parent = parent;
	}
	
	public BinaryNodeWithParent getParent() {
		return this.parent;
	}
	
	public BinaryNodeWithParent getLeftChild() {
		return (BinaryNodeWithParent)getChildren().get(0);
	}
	
	public BinaryNodeWithParent getRightChild() {
		return (BinaryNodeWithParent)getChildren().get(1);
	}
}
