package misc.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class CountSort {

	Vector<Integer>countArray; //Use a dynamic array because we don't know the size initially
	
	public static ArrayList<Integer> sort(ArrayList<Integer>arr) {
		//Initialize countArray
		int max = Integer.MIN_VALUE;
		for(int number: arr) {
			if(max < number) {
				max = number;
			}
		}
		
		System.out.println(String.format("Max is [%d]. Creating an array of that size", max));

		int[]countArray = new int[max + 1];
		for(int number: arr) {
			countArray[number] = countArray[number] + 1;
		}
		
		int index = 0;
		for(int i = 0; i < countArray.length; i++) {
			int count = countArray[i];
			while(count != 0) {
				arr.set(index,i);
				index++;
				count--;
			}
		}
		return arr;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<Integer>arr = new ArrayList<Integer>();
		String fileName = "/Users/amishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		int initialSize = arr.size();
		CountSort.sort(arr);
		if(initialSize == arr.size()){
			System.out.println(arr.toString());
			System.out.println(arr.size());
		} else {
			System.out.println("Different Size of elements returned");
		}
	}

}
