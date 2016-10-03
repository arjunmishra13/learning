package leetcode.problems;
import java.util.*;

public class AddTwoNmbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        
        if( l1 != null) {
            node.val += l1.val;
        }
        
        if( l2 != null) {
            node.val += l2.val;
        }
        
        if(node.val >= 10) {
            int quotient = 1;
            node.val = node.val%10;
            
            if( l1 != null && l1.next != null ) {
                l1.next.val += quotient;
            } else if ( l2 != null && l2.next != null ) {
                l2.next.val += quotient;
            } else {
                l1 = new ListNode(0);
                l1.next = new ListNode(quotient);
            }
        }
        
        node.next = addTwoNumbers(l1 == null?null:l1.next, l2 == null?null:l2.next);
        
        return node;
    }
    /**
     * Input: [0,7,8,0,4,7,5,3,7], [5,4,1,9,2,2,3,6,0,2]
     * Output: [5,1,0,0,7,7,6,3,1,2]
     * @param args
     */
    public static void main(String[] args) {
		
    	int[]i1 = {0,7,8,0,4,7,5,3,7};
    	int[]i2 = {5,4,1,9,2,2,3,6,0,2};
    	
    	ListNode a = buildListNode(i1);
    	printAll(a);
    	ListNode b = buildListNode(i2);
    	printAll(b);
    	
    	AddTwoNmbers add = new AddTwoNmbers();
    	ListNode n = add.addTwoNumbers(a, b);
    	
    	printAll(n);
    	
	}
	private static void printAll(ListNode n) {
		System.out.print(n.val + ",");
		ListNode nextNode = n.next;
		while(nextNode !=null) {
			System.out.print(nextNode.val + ",");
			nextNode = nextNode.next;
		}
		System.out.println();
	}
	
	/**
	 * trick is to use two temp nodes. 
	 * @param i1
	 * @return
	 */
	private static ListNode buildListNode(int[] i1) {
		ListNode root = null;
		ListNode current = root;
		for(int i=0;i<i1.length;i++) {
			if( current == null ) {
				current = new ListNode(i1[i]);
				root = current;
			} else {
				current.next = new ListNode(i1[i]);
				ListNode temp = current.next;
				current = temp;
			}
		}
		return root;
	}
}