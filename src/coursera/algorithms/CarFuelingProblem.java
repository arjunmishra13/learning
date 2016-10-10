package coursera.algorithms;

import java.util.Vector;

/**
 * Greedy algorithm. Safe move is drive to as 
 * far as possible with fuel
 * @author amishra
 *
 */
public class CarFuelingProblem {

	private Vector<Integer>refuelingPoints;
	
	public CarFuelingProblem() {
		refuelingPoints = new Vector<Integer>();
	}
	
	public void findTheStops(int[] stops, int maxDistanceBeforeEmpty) {
		
		int i=0;
		int currentDistance = 0;
		while(i<stops.length) {
			
			if(stops[i] > maxDistanceBeforeEmpty) {
				System.out.println(String.format("Cannot reach end at position {[%d], [%d]}",i,stops[i]));
				break;
			}
			while(i<stops.length) {
				currentDistance += stops[i];
				if( currentDistance > maxDistanceBeforeEmpty) {
					break;
				}
				i++;
			}
			
			refuelingPoints.add(i);
			currentDistance = 0;
		}
	}
	
	public static void main(String[] args) {
		CarFuelingProblem car = new CarFuelingProblem();
		int[]stops = new int[]{78,25,71,73,94,83,48,35,35,45,59,27,8,69,45,30,17,59,61,56,73,58,56,30,78,31,98,73,39,72,46,55,85,20,57,51,20,78,21,54,62,95,11};
		int maxDistanceBeforeEmpty = 200;
		car.findTheStops(stops,maxDistanceBeforeEmpty);
		System.out.println(car.refuelingPoints);
	}

}
