package programming.utilities;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private int key;
	private List<Node>children;
	
	public Node() {
		this.children = new LinkedList<Node>();
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node>children) {
		this.children = children;
	}
	
	public void addChildren(Node n) {
		children.add(n);
	}
	
	public String toString() {
		return Integer.toString(this.key);
	}
 }
