package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Find the max value of the expression
 * Remember that max can be max(op)max or max(op)min or min(op)max or min(op)min
 * depending on the operation
 * 
 * The trick is to use dynamic programming increasing the range as we go
 * For example give number array a[1,2,....n]
 * Range = 0
 * (min,max) of a[1,1], a[2,2], a[3,3].... a[n,n]
 * Range = 1
 * (min,max) of a[1,2], a[2,3], a[3,4].... a[n-1,n] 
 * Range = 2
 * (min,max) of a[1,3], a[2,4], a[3,5].... a[n-2,n]
 * Range = 3 
 * (min,max) of a[1,4], a[2,5], a[3,6].... a[n-3,n] 
 * .
 * .
 * .
 * Range = n-1
 * (min,max) of a[1,n]
 * 
 * Return max[1][n]
 * 
 * To evaluate min ax for range > 1, we use the previously calculated values
 * so (min,max) [1,3] = {(min,max)[1,1](op)(min,max)[2,3], (min,max)[1,2](op)(min,max)[3,3]} 
 * and (min,max) [1,5] = {(min,max)[1,1](op)(min,max)[2,5], (min,max)[1,2](op)(min,max)[3,5]}... so on 
 * 
 * Solved using dynamic programming
 * @author mishra
 *
 */
public class ParenthesisProblem {

	
	private double [][]max;
	private double [][]min;
	private Vector<Double>numbers;
	private Vector<Character>operators;
	
	public ParenthesisProblem(Vector<Double>numbers, Vector<Character>operators) {
		this.numbers = numbers;
		this.operators = operators;
		
		max = new double[numbers.size()][numbers.size()];
		min = new double[numbers.size()][numbers.size()];
	}
	
	public double getMaxValue() {
		
		for(int i=0;i<numbers.size();i++) {
			for(int j=0;j<numbers.size() - i;j++) {
				
				if(i == 0) {
					max[j][j] = numbers.get(j);
					min[j][j] = numbers.get(j);
				} else if( i == 1) {
					max[j][j + i] = getValue(numbers.get(j),numbers.get(j + i),operators.get(j));
					min[j][j + i] = getValue(numbers.get(j),numbers.get(j + i),operators.get(j));
				} else {
					double maxVal = 0, minVal = 0;
					for(int k = j;k < j + i; k++) {
						double m1 = getMax(j, k, i + j);
						double m2 = getMin(j, k, i + j);
						if( maxVal == 0 || maxVal < m1) {
							maxVal = m1;
						}
						if( minVal == 0 || minVal > m2) {
							minVal = m2;
						}
					}
					max[j][j+i] = maxVal;
					min[j][j+i] = minVal;
				}
			}
		}
		return max[0][numbers.size() - 1];
	}

	private double getMax(int start, int mid, int end) {
		double maxVal = 0;
		double val1 = getValue(max[start][mid], max[mid+1][end],operators.get(mid));
		if(maxVal == 0 || maxVal < val1) {
			maxVal = val1;
		}
		double val2 = getValue(max[start][mid], min[mid+1][end],operators.get(mid));
		if(maxVal < val2) {
			maxVal = val2;
		}
		double val3 = getValue(min[start][mid], max[mid+1][end],operators.get(mid));
		if(maxVal < val3) {
			maxVal = val3;
		}
		double val4 = getValue(min[start][mid], min[mid+1][end],operators.get(mid));
		if(maxVal < val4) {
			maxVal = val4;
		}
		
		return maxVal;
	}

	private double getMin(int start, int mid, int end) {
		double minVal = 0;
		double val1 = getValue(max[start][mid], max[mid+1][end],operators.get(mid));
		if(minVal == 0 || minVal > val1) {
			minVal = val1;
		}
		double val2 = getValue(max[start][mid], min[mid+1][end],operators.get(mid));
		if(minVal > val2) {
			minVal = val2;
		}
		double val3 = getValue(min[start][mid], max[mid+1][end],operators.get(mid));
		if(minVal > val3) {
			minVal = val3;
		}
		double val4 = getValue(min[start][mid], min[mid+1][end],operators.get(mid));
		if(minVal > val4) {
			minVal = val4;
		}
		
		return minVal;
	}
	
	private double getValue(double val1, double val2, char op) {
		double value = 0;
		
		switch(op) {
		case '+':
			value = val1 + val2;
			break;
		case '-':
			value = val1 - val2;
			break;
		case '*':
			value = val1*val2;
			break;
		case '%':
			if(val2 != 0) {
				value = val1/val2;
				break;
			}
		}
		return value;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "/Users/mishra/Desktop/Projects/Test/ParenthesisProblem.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		Vector<Double>numbers = new Vector<Double>();
		Vector<Character>operators = new Vector<Character>();
		while(line != null) {
			String[] arr = line.split("\t");
			double number = Double.parseDouble(arr[0]);
			if(arr.length > 1) {
				char operator = arr[1].charAt(0);
				operators.add(operator);
			}
			numbers.add(number);
			line = bufferedReader.readLine();
		}

		bufferedReader.close();
		ParenthesisProblem problem = new ParenthesisProblem(numbers, operators);
		System.out.println("Numbers\t\t" + numbers + "\nOperators\t" + operators);
		System.out.println("Max Value\t" + problem.getMaxValue());
	}
}
