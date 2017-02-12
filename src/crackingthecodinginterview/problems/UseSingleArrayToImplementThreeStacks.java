package crackingthecodinginterview.problems;

/**
 * Problem 3.1
 * @author mishra
 *
 */
public class UseSingleArrayToImplementThreeStacks {

	private int stack1Index, stack2Index, stack3Index;
	private int eachStackSize;
	private int[]arr;
	public UseSingleArrayToImplementThreeStacks(int size) {
		this.eachStackSize = size;
		this.arr = new int[size*3];
	}
	
	public void push(int element, int stack) throws IndexOutOfBoundsException, Exception {
		
		switch(stack) {
		case 1:
			if(stack1Index >= eachStackSize) {
				throw new IndexOutOfBoundsException();
			}
			arr[stack1Index] = element;
			if(stack2Index == stack1Index + 1) {
				shiftUp(stack1Index);
			}
			stack1Index++;
			stack2Index++;
			stack3Index++;
			break;
		case 2:
			if(stack2Index >= eachStackSize) {
				throw new IndexOutOfBoundsException();
			}
			arr[stack2Index] = element;
			if(stack3Index == stack2Index + 1) {
				shiftUp(stack2Index);
			}
			stack2Index++;
			stack3Index++;
			break;
		case 3:
			if(stack3Index >= eachStackSize) {
				throw new IndexOutOfBoundsException();
			}
			arr[stack1Index] = element;
			shiftUp(stack3Index);
			stack3Index++;
			break;
		default:
			throw new Exception("Invalid stack id. Choose values between 1 - 3");
		}
	}
	
	private void shiftUp(int start) {
		
		int last = stack3Index;
		while(last > start) {
			arr[last + 1] = arr[last];
			last--;
		}
	}
	
	public int pop(int stack) throws IndexOutOfBoundsException, Exception {
		int outElement = 0;
		switch(stack) {
		case 1:
			if(stack1Index == 0) {
				throw new IndexOutOfBoundsException();
			}
			stack1Index--;
			outElement = arr[stack1Index];
			arr[stack1Index] = 0;
			shiftUp(stack1Index);
			break;
		case 2:
			if(stack2Index <= stack1Index + 1) {
				throw new IndexOutOfBoundsException();
			}
			stack2Index--;
			outElement = arr[stack2Index];
			arr[stack2Index] = 0;
			break;
		case 3:
			if(stack3Index <= stack2Index + 1) {
				throw new IndexOutOfBoundsException();
			}
			stack3Index--;
			outElement = arr[stack1Index];
			arr[stack3Index] = 0;
			break;
		default:
			throw new Exception("Invalid stack id. Choose values between 1 - 3");
		}
		
		return outElement;
	}

	
	public int top(int stack) throws IndexOutOfBoundsException, Exception {
		switch(stack) {
		case 1:
			if(stack1Index == 0) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack1Index - 1];
		case 2:
			if(stack2Index <= stack1Index + 1) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack2Index-1];
		case 3:
			if(stack3Index <= stack2Index + 1) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack3Index - 1];
		default:
			throw new Exception("Invalid stack id. Choose values between 1 - 3");
		}
	}

	public static void main(String[] args) throws IndexOutOfBoundsException, Exception {
		int size = 5;
		
		UseSingleArrayToImplementThreeStacks stack = new UseSingleArrayToImplementThreeStacks(size);
		stack.push(5, 1);
		stack.push(2, 2);
		stack.push(7, 3);
	}
}
