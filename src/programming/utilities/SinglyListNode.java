package programming.utilities;


public class SinglyListNode {

	private int key;
	private SinglyListNode next;
	
	public SinglyListNode() {
		
	}

	public SinglyListNode(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public SinglyListNode getNext() {
		return next;
	}
	public void setNext(SinglyListNode next) {
		this.next = next;
	}
	
	public boolean hasNext() {
		return this.getNext() != null;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		SinglyListNode next = this;
		while(next != null) {
			str.append(next.getKey()).append(", ");
			next = next.getNext();
		}
		return str.toString();
	}

//	public String toString() {
//		
//		return Integer.toString(getKey());
//	}
 }
