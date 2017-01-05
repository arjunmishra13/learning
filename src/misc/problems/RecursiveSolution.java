package misc.problems;

public class RecursiveSolution extends TowerOfHanoi{

	public RecursiveSolution() {
		super();
	}
	
	/*
	 * Trick is alternate between smallest and non-smallest
	 * Always go in one direction, and circle back
	 * When n is odd, go left to right
	 * When n is even go right to left
	 * (non-Javadoc)
	 * @see misc.problems.TowerOfHanoi#solve()
	 */
	private int positionOfTheSmallest = 0;
	private boolean pickSmallest = true;
	@Override
	public void solve() {
		
		if(towers.get(2).size() == numberOfElements) {
			return;
		}
		
		if(pickSmallest) {
			int element = popNextMove(positionOfTheSmallest);
			int position = getNextPosition(element, positionOfTheSmallest);
			towers.get(position).push(element);
			positionOfTheSmallest = position;
			
		} else {
			int positionOfTheNonSmallest = getNonSmallestPosition();
			int element = popNextMove(positionOfTheNonSmallest);
			int position = getNextPosition(element, positionOfTheNonSmallest);
			towers.get(position).push(element);
		}
		
		pickSmallest = !pickSmallest;
		solve();
	}
	
	private int getNonSmallestPosition() {
		int nonSmallestIndex = -1;
		int nonSmallestValue = Integer.MAX_VALUE;
		for(int i = 0;i<towers.size();i++) {
			if(!towers.get(i).isEmpty() && i != positionOfTheSmallest) {
				if(nonSmallestValue > towers.get(i).peek()) {
					nonSmallestValue = towers.get(i).peek();
					nonSmallestIndex = i;
				}
			}
		}
		if(nonSmallestIndex == -1) {
			System.out.println("ERROR: Could not find the non smallest position");
		}
		return nonSmallestIndex;
	}
	
	private int getNextPosition(int element, int nextPosition) {
		
		for(int i=0; i<3;i++) {
			if(numberOfElements%2!=0) {
				nextPosition--;
				if(nextPosition < 0) {
					nextPosition = 2;
				}
			} else {
				nextPosition++;
				if(nextPosition > 2) {
					nextPosition = 0;
				}
			}
			if(towers.get(nextPosition).isEmpty() || element < towers.get(nextPosition).peek()) {
				return nextPosition;
			}
		}
		System.out.println("ERROR: COULD NOT FIND THE NEXT BUCKET");
		return -1;
	}

	private int popNextMove(int position) {
		
		if(position >= towers.size()) {
			System.out.println("ERROR: Position greater than 3");
			return -1;
		} else {
			return towers.get(position).pop();
		}
	}
	
	public static void main(String[] args) {
		
		int n = 7;
		TowerOfHanoi tower = new RecursiveSolution();
		tower.initialize(n);
		tower.solve();
		System.out.println(tower.getResult());
	}
}
