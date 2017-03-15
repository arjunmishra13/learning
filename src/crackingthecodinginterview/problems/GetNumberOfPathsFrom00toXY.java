package crackingthecodinginterview.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem 9.2
 * @author mishra
 * 
 * My solution - Recursive. To get to X,Y you can get from X - 1, Y or X, Y - 1
 *
 */
public class GetNumberOfPathsFrom00toXY {
/*
 * If all paths were accesible - Solution - (X + Y)!/(X!*Y!)
 */
	
	int x;
	int y;
	public GetNumberOfPathsFrom00toXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	class Position {
		int x;
		int y;
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override 
		public String toString() {
			return this.x + "," + this.y;
		}
	}
	
	List<List<Position>>allPositions = new LinkedList<List<Position>>();
	
	public void getAllPaths(int x, int y, List<Position>pos, List<Position> unAvailablePoints) {
		
		if(pointIsUnavailable(x,y,unAvailablePoints)) {
			return;
		}
		
		if(x == 0 && y == 0) {
			pos.add(new Position(0,0));
			allPositions.add(pos);
			pos = new LinkedList<Position>();
			return;
		}
		
		pos.add(new Position(x,y));
		List<Position>temp = new LinkedList<Position>(pos);
		if(x > 0) {
			getAllPaths(x - 1, y, pos, unAvailablePoints);
		}
		
		if(pos.size() == (this.x + this.y + 1)) {
			pos = temp;
		}
		
		if(y > 0) {
			getAllPaths(x, y - 1, pos, unAvailablePoints);
		}
	}
	
	public int getNumberPaths(int x, int y, List<Position> unAvailablePoints) {
		
		if(pointIsUnavailable(x,y,unAvailablePoints)) {
			return 0;
		}
		
		if(x == 0 && y == 0) {
			return 1;
		}
		
		int numberOfPaths = 0;
		numberOfPaths += x > 0 ? getNumberPaths(x - 1, y, unAvailablePoints): 0;
		numberOfPaths += y > 0 ? getNumberPaths(x, y - 1, unAvailablePoints): 0;
		
		return numberOfPaths;
		
	}

	private boolean pointIsUnavailable(int x, int y, List<Position> unAvailablePoints) {
		
		for(Position pos: unAvailablePoints) {
			if(pos.x == x && pos.y == y) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int x = 6;
		int y = 6;
		
		GetNumberOfPathsFrom00toXY pathsObj = new GetNumberOfPathsFrom00toXY(x,y);
		List<Position>unAvailablePoints = new LinkedList<Position>();
		Position pos1 = pathsObj.new Position(1,0);
		unAvailablePoints.add(pos1);
		
		pathsObj.getAllPaths(x, y, new LinkedList<Position>(), unAvailablePoints);
		
		System.out.println(pathsObj.allPositions);
		System.out.println("Find all paths size:\t" + pathsObj.allPositions.size());
		System.out.println("Number of paths count:\t" + pathsObj.getNumberPaths(x, y, unAvailablePoints));
	}
}
