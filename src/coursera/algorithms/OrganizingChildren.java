package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import misc.problems.MergeSort;

public class OrganizingChildren {

	/**
	 * Find all possible partitions where the difference
	 * between min and max age of children in each partition
	 * is utmost 1
	 * 
	 * Sort the ages, then with the minimum to minimum + 1, make a set
	 * then move on 
	 * NOTE: Always reformulate problem in
	 * mathematical terms
	 * @param args
	 */
	
	//Map of min group age (group identifier) to list of children's age
	Vector<Group>groups = new Vector<Group>();
	private void splitChildren(Vector<Double>ages) {
		ages = MergeSort.mergeSort(ages,0,ages.size() - 1);
		for(int i=0;i<ages.size();i++) {
			
			boolean wasAdded = false;
			for(Group g: groups) {
				if(ages.get(i) >= g.identifier && ages.get(i) < (g.identifier + 1)) {
					g.addAge(ages.get(i));
					wasAdded = true;
				}
			}
			
			if(!wasAdded) {
				Group g = new Group();
				g.setIdentifier(ages.get(i));
				g.addAge(ages.get(i));
				groups.add(g);
			}
		}
	}
	private class Group {
		private double identifier;
		private Vector<Double>ages;
		public Group(){
			ages = new Vector<Double>();
		}
		public void setIdentifier(double identifier) {
			this.identifier = identifier;
		}
		public void addAge(double age) {
			this.ages.add(age);
		}
		
		@Override
		public String toString() {
			return ages.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		OrganizingChildren org = new OrganizingChildren();


		String fileName = "/Users/mishra/Desktop/Projects/Test/OrganizeChildren.txt";
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		Vector<Double>ages = new Vector<Double>();
		while(line != null) {
			ages.add(Double.parseDouble(line));
			line = bufferedReader.readLine();
		}
		org.splitChildren(ages);
		System.out.println(org.groups);
	}
}
