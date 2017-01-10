package coursera.datastructures;

import java.util.Vector;

public class DisjointSets {

	/**
	 * Abstract data structures to perform operations
	 * such as Union(A,B) - Union of two sets,
	 * Find(x) - returns the identitiy of a set, 
	 * MakeSet(x) - creates a set
	 * 
	 * Efficient implementation is as a tree, with the root being the identifier of a set,
	 * and union will be on the root
	 *  
	 * Need two attributes 
	 * 1. Map of node to parent, for returning the id faster
	 * 2. Map of node to rank for more efficient merging. Rank is the height of the subtree
	 *  
	 * LEMMA - Height of DisjointSets tree is O(log(N)) 
	 * LEMMA - For a given height k, there will be at least 2^k elements
	 *  
	 * Using path compression, we can reduce the running time to nearly constant
	 * 
	 * To simplify work with integers and use arrays instead
	 */
	private Vector<Integer>parents = new Vector<Integer>();
	private Vector<Integer>rank = new Vector<Integer>();
	
	
	/*
	 * Create a single set or a node with no children with x
	 * Set t's parent to itself, and rank to 1
	 */
	public void makeSet(int x) {
		
		while(parents.size() <= x) {
			parents.add(0);
			rank.add(0);
		}
		
		parents.set(x, x);
		rank.set(x, 1);
	}
	
	/*
	 * Return the identifier of the node
	 */
	public int find(int x) {
		
		while(parents.get(x) != x) {
			x = parents.get(x);
		}
		
		return x;
	}
	
	/*
	 * Path compression is setting the parent of every traversed node to the root
	 * So basically every node is attached to the root
	 */
	public int pathComressionFind(int x) {
		
		if(parents.get(x) == x) {
			return parents.get(x);
		}
		
		parents.set(x, pathComressionFind(parents.get(x)));
		
		return parents.get(x);
	}
	
	/*
	 * Merge two sets that have elements
	 * x and y
	 */
	public void merge(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		//If x and y belong to the same set return
		if(parentX == parentY) {
			return;
		}
		
		//If X has more depth, merge Y to X else, otherwise
		if(rank.get(parentX) > rank.get(parentY)) {
			parents.set(parentY, parentX);
		} else {
			parents.set(parentX, parentY);
			//Only if the ranks were equal, on merging the rank of the top parent node will be incremented by 1
			if(rank.get(parentX) == rank.get(parentY)) {
				rank.set(parentY, rank.get(parentY) + 1);
			}
		}
	}
	
	public Vector<Integer> getParentArray() {
		return parents;
	}
	
	public Vector<Integer> getRankArray() {
		return rank;
	}
	
	public static void main(String[] args) {
		DisjointSets sets = new DisjointSets();
		
		sets.makeSet(0);
		sets.makeSet(1);
		sets.makeSet(2);
		sets.makeSet(3);
		sets.makeSet(4);
		sets.makeSet(5);
		System.out.println(sets.getParentArray());
		System.out.println(sets.getRankArray());
		System.out.println();
		
		//Merge (0,1), (2,3,4)
		sets.merge(0, 1);
		sets.merge(2, 3);
		sets.merge(3, 4);
		System.out.println(sets.getParentArray());
		System.out.println(sets.getRankArray());
		System.out.println();
		
		//Merge (0,2)
		sets.merge(0, 2);
		System.out.println(sets.getParentArray());
		System.out.println(sets.getRankArray());
		System.out.println();
		
		
	}
}
