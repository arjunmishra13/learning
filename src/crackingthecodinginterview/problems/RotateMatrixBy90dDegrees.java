package crackingthecodinginterview.problems;
/**
 * problem 1.6
 * @author mishra
 *
 */
public class RotateMatrixBy90dDegrees {

	public static int[][] rotateLeft(int [][]matrix) {
		int[][]rotatedMatrix = new int[matrix.length][matrix.length];
		for(int i = 0; i<matrix.length;i++) {
			for(int j = 0; j<matrix.length;j++) {
				rotatedMatrix[matrix.length - 1 - j][i] = matrix[i][j]; 
			}
		}
		
		return rotatedMatrix;
	}
	
	public static void generateMatrix(int [][]matrix) {
		for(int i = 0; i<matrix.length;i++) {
			for(int j = 0; j<matrix.length;j++) {
				matrix[i][j] = (int)(Math.random()*10);
			}
		}
	}
	
	public static void print(int[][]matrix) {
		for(int i = 0; i<matrix.length;i++) {
			for(int j = 0; j<matrix.length;j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int N = 4;
		int[][]matrix = new int[N][N];
		RotateMatrixBy90dDegrees.generateMatrix(matrix);
		RotateMatrixBy90dDegrees.print(matrix);
		int[][]rotatedMatrix = RotateMatrixBy90dDegrees.rotateLeft(matrix);
		System.out.println();
		RotateMatrixBy90dDegrees.print(rotatedMatrix);
	}
}
