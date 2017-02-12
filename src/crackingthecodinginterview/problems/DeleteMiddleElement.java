package crackingthecodinginterview.problems;

import programming.utilities.SinglyListNode;

/**
 * Problem 2.3
 * @author mishra
 *
 */
public class DeleteMiddleElement {

	public static void deleteMiddleElement(SinglyListNode mid) {	
		
		SinglyListNode next = mid.getNext();
		mid.setKey(next.getKey());
		mid.setNext(next.getNext());
		
	}
	
	public static SinglyListNode buildListReturnMid(int currentCount, int maxCount) {
		
		if(currentCount > maxCount) {
			return null;
		}
		
		SinglyListNode node = new SinglyListNode();
		node.setKey((int)(Math.random()*10.0));
		currentCount++;
		node.setNext(buildListReturnMid(currentCount, maxCount));
		
		return node;
	}
	
	public static SinglyListNode getMid(SinglyListNode root, int max) {
		int index = 1;
		SinglyListNode mid = root.getNext();
		while(mid != null && index < max/2) {
			root = mid;
			mid = root.getNext();
			index++;
		}
		
		return mid;
	}
	
	
	
	public static void main(String[] args) {
		int max = 10;
		SinglyListNode root = buildListReturnMid(1, max);
		SinglyListNode mid = getMid(root, max);
		System.out.println(root.toString() + "\t\tMid\t" + mid);
		deleteMiddleElement(mid);
		System.out.println(root.toString());
	}
}
