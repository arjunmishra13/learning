package misc.problems;

import programming.utilities.BinaryNode;
import programming.utilities.TreeTraversal;
import programming.utilities.TreeTraversalFactory;

public class TraverseBinaryTrees {
	
	/* Base Tree (As a Binary Max Heap)
	 * 								15
	 * 				7								14			
	 * 		5				6				12				13	
	 * 	1		2		3		4		11		9		10		8			
	 */
	TreeTraversal<BinaryNode>traverse;
	
public static BinaryNode buildTree1(BinaryNode root) {
		
		/* Base Tree (As a Binary Max Heap)
		 * 								15
		 * 				7								14			
		 * 														13	
		 */
		BinaryNode n7 = new BinaryNode();
		n7.setKey(7);
		BinaryNode n14 = new BinaryNode();
		n14.setKey(14);
		BinaryNode n13 = new BinaryNode();
		n13.setKey(13);
		
		root.setLeftChild(n7);
		root.setRightChild(n14);
		n14.setRightChild(n13);
		return root;
	}
	
	public static BinaryNode buildTree2(BinaryNode root) {
		
		/* Base Tree (As a Binary Max Heap)
		 * 								15
		 * 				7								14			
		 * 		5				6				12				13	
		 * 					3		4				9							
		 */
		BinaryNode n7 = new BinaryNode();
		n7.setKey(7);
		BinaryNode n14 = new BinaryNode();
		n14.setKey(14);
		BinaryNode n5 = new BinaryNode();
		n5.setKey(5);
		BinaryNode n6 = new BinaryNode();
		n6.setKey(6);
		BinaryNode n12 = new BinaryNode();
		n12.setKey(12);
		BinaryNode n13 = new BinaryNode();
		n13.setKey(13);
		BinaryNode n3 = new BinaryNode();
		n3.setKey(3);
		BinaryNode n4 = new BinaryNode();
		n4.setKey(4);
		BinaryNode n9 = new BinaryNode();
		n9.setKey(9);
		
		root.setLeftChild(n7);
		root.setRightChild(n14);
		
		n7.setLeftChild(n5);
		n7.setRightChild(n6);
		
		n14.setLeftChild(n12);
		n14.setRightChild(n13);
		
		n6.setLeftChild(n3);
		n6.setRightChild(n4);
		
		n12.setRightChild(n9);
		return root;
	}
	
	public static void main(String[] args) {
		
		BinaryNode root = new BinaryNode();
		root.setKey(15);
		root = TraverseBinaryTrees.buildTree2(root);
		
		//Different Traversal
		System.out.println("In Order Tree Traversal");
		TreeTraversalFactory.traverseBinaryTree("InOrderTreeTraversal", root);
		System.out.println();
		System.out.println("Pre Order Tree Traversal");
		TreeTraversalFactory.traverseBinaryTree("PreOrderTreeTraversal", root);
		System.out.println();
		System.out.println("Post Order Tree Traversal");
		TreeTraversalFactory.traverseBinaryTree("PostOrderTreeTraversal", root);
		System.out.println();
		System.out.println("Level First Tree Traversal");
		TreeTraversalFactory.traverseBinaryTree("LevelFirstTreeTraversal", root);
	}
}
