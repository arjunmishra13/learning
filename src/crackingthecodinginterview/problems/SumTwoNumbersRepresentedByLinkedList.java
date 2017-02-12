package crackingthecodinginterview.problems;

import java.util.Iterator;
import java.util.LinkedList;

public class SumTwoNumbersRepresentedByLinkedList {

	/**
	 * Problem 2.5
	 */
	
	public static LinkedList<Integer> addWithUnitsAtFront(LinkedList<Integer>num1, LinkedList<Integer>num2) {
		Iterator<Integer>num1Itr = num1.iterator();
		Iterator<Integer>num2Itr = num2.iterator();
		
		LinkedList<Integer>sum = new LinkedList<Integer>();
		int carryOver = 0;
		while(num1Itr.hasNext() || num2Itr.hasNext()) {
			int number1 = num1Itr.hasNext()?num1Itr.next():0;
			int number2 = num2Itr.hasNext()?num2Itr.next():0;
			
			if(number1 > 9 || number2 > 9) {
				return null;
			}
			int result = number1 + number2 + carryOver;
			sum.add(result%10);
			carryOver = result/10;
		}
		
		if(carryOver > 0) {
			sum.add(carryOver);
		}
		
		return sum;
	}

	public static LinkedList<Integer> addWithUnitsAtEnd(LinkedList<Integer>num1, LinkedList<Integer>num2) {
		LinkedList<Integer>sumResult = new LinkedList<Integer>();
		int carryOver = 0;
		while(!num1.isEmpty() || !num2.isEmpty()) {
			int num1Last = num1.isEmpty()?0:num1.removeLast();
			int num2Last = num2.isEmpty()?0:num2.removeLast();
			
			int sum = num1Last + num2Last + carryOver;
			sumResult.addFirst(sum%10);
			carryOver = sum/10;
		}
		
		if(carryOver > 0) {
			sumResult.addFirst(carryOver);
		}
		return sumResult;
	}
	
	public static void main(String[] args) {

		LinkedList<Integer>num1 = new LinkedList<Integer>();
		LinkedList<Integer>num2 = new LinkedList<Integer>();
		
		num1.add(1);
		num1.add(5);
		
		num2.add(2);
		num2.add(7);
		System.out.println(num1 + "\t+\t" + num2 + "\t=" + SumTwoNumbersRepresentedByLinkedList.addWithUnitsAtFront(num1, num2));
		System.out.println(num1 + "\t+\t" + num2 + "\t=" + SumTwoNumbersRepresentedByLinkedList.addWithUnitsAtEnd(num1, num2));
	}
}
