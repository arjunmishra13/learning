package programming.utilities;

public class DoublyListNode extends SinglyListNode{

	DoublyListNode previous;
	
	public DoublyListNode(int key) {
		super(key);
	}
	public DoublyListNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(DoublyListNode previous) {
		this.previous = previous;
	}
	
	public boolean hasPrevious() {
		return this.getPrevious() != null;
	}
	
	@Override
	public DoublyListNode getNext() {
		return (DoublyListNode)super.getNext();
	}
}
