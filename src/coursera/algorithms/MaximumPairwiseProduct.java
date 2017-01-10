package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Involves finding the two highest numbers and returning their product
 * @author mishra
 *
 */
public class MaximumPairwiseProduct {

	public static <T extends Number> double getMaximumPairwiseProduct(Vector<T>nums) {
		if(nums == null || nums.isEmpty()) {
			return 0.0;
		}
		double max = Double.MIN_VALUE, secondMax = Double.MIN_VALUE;

		for(T number: nums) {
			
			if(max < number.doubleValue()) {
				secondMax = max;
				max = number.doubleValue();
			} else if(secondMax < number.doubleValue()) {
				secondMax = number.doubleValue();
			}
		}
		
		if(secondMax == Double.MIN_VALUE) {
			return max;
		} else {
			return max*secondMax;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Vector<Integer>arr = new Vector<Integer>();
		String fileName = "/Users/mishra/Desktop/Projects/Test/SortNumbers.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		while(line != null) {
			arr.add(Integer.parseInt(line));
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		System.out.println(arr.toString());
		System.out.println(MaximumPairwiseProduct.getMaximumPairwiseProduct(arr));
	}
}
