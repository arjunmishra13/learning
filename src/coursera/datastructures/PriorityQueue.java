package coursera.datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class PriorityQueue {

	/**
	 * <p>Priorty Queue is a abstract datastructure which
	 * stores objects and performs specific operations like 
	 * ExtractMax() - returns object with largest priority
	 * Insert(Object o) - adds an object so as to retrieve it later
	 * ChangePriority(Object o, p) - Change priority of an object
	 * Remove(Object o) - Remove an object
	 * GetMax() - Get the object with highest priority
	 * The best way to implement a priorty queue would be 
	 * as a Binary Max Heap tree, where the parent is at least two of it's
	 * children. Time for most opeartions would be heihgt of tree
	 * We can restrict it to O(log(n)) if the tree is complete
	 * A Complete Binary Max Heap Tree or simply binary heap, is
	 * a binary max heap tree where insertions always occur from 
	 * left to right 
	 * </p>
	 * <p>
	 * A complete binary max heap tree is easily implemented using arrays,
	 * where for every parent i, left child is 2*i and right child is 2*i + 1.
	 * Similarly for every child i, parent is Floor(i/2)
	 * </p>
	 */
	
	//initialize a vector to store objects. For sake of practice simply use integers
	Vector<Integer>vector;
	
	public PriorityQueue() {
		vector = new Vector<Integer>();
	}
	
	/*
	 * To insert, add the new element to 
	 * the end of the tree ( or array )
	 * and call shift up operation
	 */
	public void insert(int a) {
		
		vector.add(a);
		shiftUp(vector.size() - 1);
	}
	
	/*
	 * Returns the element with max priority
	 * Way to do it is to swap it with the last
	 * leaf node, trim that leaf, and call shift down on 
	 * root. The leaf is the last element in the array,
	 * and the root is the first
	 */
	public int extractMax() {
		int max = vector.firstElement(); //Get the max element
		vector.set(0, vector.lastElement()); //Set the root to leaf
		vector.remove(vector.size() - 1); //Trim the leaf
		
		shiftDown(0);//Shift the root node down
		return max;
	}
	
	
	/*
	 * Update priority and then call shift up or down depending 
	 * on the value of current to previous
	 */
	public void updatePriority(int index, int priority) {
		
		if(index >= vector.size()) {
			return;
		}
		
		int currentValue = vector.get(index);
		vector.set(index, priority);
		if(priority > currentValue) {
			shiftUp(index);
		} else if(priority < currentValue) {
			shiftDown(index);
		}
	}
	
	/*
	 * To remove an index we use a trick
	 * We UPDATE the value to infinity and push it up,
	 * then we call extract max
	 */
	public void remove(int index) {
		if(index >= vector.size()) {
			return;
		}
		updatePriority(index, Integer.MAX_VALUE);
		extractMax();
	}
	
	/*
	 * Return the root or the first element in the array  
	 */
	public int getMax() {
		return vector.firstElement();
	}
	
	/*
	 * Heap Sort Naive - Build a Complete Binary Max Heap Tree
	 * Once fully built keep extracting 
	 * TimeComplexity = O(n*log(n))
	 */
	public Vector<Integer> heapSortNaive(Vector<Integer>arr) {
		Vector<Integer>sortedArray = new Vector<Integer>(arr);
		for(int a: arr) {
			insert(a);
		}
		for(int i = 1; i<=arr.size();i++) {
			sortedArray.set(arr.size() - i,extractMax());
		}
		return sortedArray;
	}
	
	/*
	 * We can imrpove on the previous sort algorithm 
	 * Instead of inserting every element
	 * we call shift down on the first n/2 elements,
	 * since the last n/2 elements are definitely leaf nodes
	 * To sort swap first and last, then reduce size to size - 1 and call shift down
	 */
	
	/*
	 * ShiftUp on index recursively,
	 * by comparing with parent, and if
	 * it is strictly greater swap and call again 
	 */
	private void shiftUp(int index) {

		if(index == 0) {
			//you are at the root
			return;
		}
		int parent = Math.floorDiv(index + 1, 2) - 1;
		if(vector.get(parent) < vector.get(index) ) {
			//swap parent with current and call shift up again
			int temp = vector.get(parent);
			vector.set(parent, vector.get(index));
			vector.set(index, temp);
			
			index = parent;
			shiftUp(index);
		} else {
			return;
		}
	}
	
	/*
	 * To shift down compare the parent with children node,
	 * swap with the node that higher of the two
	 */
	public void shiftDown(int index) {
		
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		
		if(leftChild >= vector.size()) {//No left or right node
			return;
		} else if( rightChild >= vector.size()) {//No right node
			if(vector.get(index) < vector.get(leftChild)) {
				int temp = vector.get(index);
				vector.set(index, vector.get(leftChild));
				vector.set(leftChild, temp);
				index = leftChild;
				shiftDown(index);
			}
		} else {
			if( (vector.get(index) < vector.get(leftChild)) || (vector.get(index) < vector.get(rightChild))) {
				int temp = vector.get(index);
				if(vector.get(leftChild) > vector.get(rightChild)) {
					vector.set(index, vector.get(leftChild));
					vector.set(leftChild, temp);
					index = leftChild;
				} else {
					vector.set(index, vector.get(rightChild));
					vector.set(rightChild, temp);
					index = rightChild;
				}
				
				shiftDown(index);
			} else {
				return;
			}
		}
	}
	
	public Vector<Integer> getHeap() {
		return vector;
	}
	
	public static void main(String[] args) throws IOException {
		
		PriorityQueue priorityQueue = new PriorityQueue();
		
		String fileName = "/Users/mishra/Desktop/Projects/Test/SortNumbers.txt";
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		Vector<Integer>arr = new Vector<Integer>();
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		
		//insert first 12 elements
		for(int i = 0; i<12;i++) {
			priorityQueue.insert(arr.get(i));
		}
		
		System.out.println("Original Array:\t" + arr);
		System.out.println("Insert 12 Heap:\t" + priorityQueue.getHeap());
		//ExtractMax twice
		for(int i = 0;i<2;i++) {
			System.out.println("ExtractMax:\t" + priorityQueue.extractMax());
		}
		
		System.out.println("Post Extract Heap:\t" + priorityQueue.getHeap());
		
		//Update priority of the 4th to 5, and 7th to 3
		priorityQueue.updatePriority(3, 5);
		priorityQueue.updatePriority(6,3);
		
		System.out.println("Update 4th to 5 and 7th to 3 Heap:\t" + priorityQueue.getHeap());
		
		//Remove the 2nd, 3th, and 5th element
		priorityQueue.remove(1);
		priorityQueue.remove(2);
		priorityQueue.remove(4);
		
		System.out.println("Remove 2nd, 3rd and 5th Heap:\t" + priorityQueue.getHeap());
		System.out.println("Get Max:\t" + priorityQueue.getMax());
		
		System.out.println("Heap Sort Original Input");
		System.out.println(priorityQueue.heapSortNaive(arr));
	}
}
