package programming.utilities;

public class TreeTraversalFactory {

	public static TreeTraversal<?> getTreeTraversal(String type) {

		switch (type) {
		case "InOrderTreeTraversal":
			return new InOrderTreeTraversal();
		case "PreOrderTreeTraversal":
			return new PreOrderTraversal();
		case "PostOrderTreeTraversal":
			return new PostOrderTraversal();
		case "LevelFirstTreeTraversal":
			return new LevelFirstTraversal();
		default:
			return null;
		}
	}

	public static void traverseBinaryTree(String type, Node node) {

		switch (type) {
		case "InOrderTreeTraversal":
			(new InOrderTreeTraversal()).traverse((BinaryNode) node);
			break;
		case "PreOrderTreeTraversal":
			(new PreOrderTraversal()).traverse((BinaryNode) node);
			break;
		case "PostOrderTreeTraversal":
			(new PostOrderTraversal()).traverse((BinaryNode) node);
			break;
		case "LevelFirstTreeTraversal":
			(new LevelFirstTraversal()).traverse((BinaryNode) node);
			break;
		default:
			return;
		}
	}
}
