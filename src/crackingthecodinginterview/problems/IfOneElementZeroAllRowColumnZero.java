package crackingthecodinginterview.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 1.7
 * @author mishra
 *
 */
public class IfOneElementZeroAllRowColumnZero {

	public static void findZeroSetRowColumn(int [][]matrix) {
		Set<Integer>zeroRow = new HashSet<Integer>();
		Set<Integer>zeroColumn = new HashSet<Integer>();
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(matrix[i][j] == 0) {
					zeroRow.add(i);
					zeroColumn.add(j);
				}
			}
		}
		//Set all row elements to 0
		for(int row:zeroRow) {
			matrix[row] = new int[matrix.length];
		}
		
		//Set all column elements to 0
		for(int column:zeroColumn) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][column]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 4;
		int [][]matrix = new int[N][N];
		RotateMatrixBy90dDegrees.generateMatrix(matrix);
		RotateMatrixBy90dDegrees.print(matrix);
		System.out.println();
		IfOneElementZeroAllRowColumnZero.findZeroSetRowColumn(matrix);
		RotateMatrixBy90dDegrees.print(matrix);
	}
}
