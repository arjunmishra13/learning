package crackingthecodinginterview.problems;

/**
 * Problem 3.1
 * @author mishra
 *
 */
public class UseSingleArrayToImplementThreeStacks {

	private int stack1Index = -1, stack2Index = -1, stack3Index = -1;//Represents the last element index for that stack
//	private int eachStackSize;
	private int[]arr;
	public UseSingleArrayToImplementThreeStacks(int size) {
//		this.eachStackSize = size;
		this.arr = new int[size*3];
	}
	
	public void push(int element, int stack) throws IndexOutOfBoundsException, Exception {
		
		switch(stack) {
		case 1:
			if(stack1Index >= arr.length) {
				throw new IndexOutOfBoundsException();
			}
			if( stack1Index != -1 && stack3Index != stack1Index) {
				shiftUp(stack1Index);
			}
			stack1Index++;
			stack2Index++;
			stack3Index++;
			arr[stack1Index] = element;
			break;
		case 2:
			if(stack2Index >= arr.length) {
				throw new IndexOutOfBoundsException();
			}
			if(stack2Index != -1 && stack3Index != stack2Index) {
				shiftUp(stack2Index);
			}
			stack2Index++;
			stack3Index++;
			arr[stack2Index] = element;
			break;
		case 3:
			if(stack3Index >= arr.length) {
				throw new IndexOutOfBoundsException();
			}
			if(stack3Index != -1) {
				shiftUp(stack3Index);
			}
			stack3Index++;
			arr[stack3Index] = element;
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

	private void shiftDown(int start) {
		
		while(start < stack3Index) {
			arr[start] = arr[start + 1];
			start++;
		}
		arr[stack3Index] = 0;
	}
	
	public int pop(int stack) throws IndexOutOfBoundsException, Exception {
		int outElement = 0;
		switch(stack) {
		case 1:
			if(stack1Index == -1) {
				throw new IndexOutOfBoundsException();
			}
			outElement = arr[stack1Index];
			shiftDown(stack1Index);
			stack1Index--;
			stack2Index--;
			stack3Index--;
			break;
		case 2:
			if(stack2Index == -1 || (stack2Index == stack1Index)) {
				throw new IndexOutOfBoundsException();
			}
			outElement = arr[stack2Index];
			shiftDown(stack2Index);
			stack2Index--;
			stack3Index--;
			break;
		case 3:
			if(stack3Index == -1 || (stack3Index == stack2Index)) {
				throw new IndexOutOfBoundsException();
			}
			outElement = arr[stack3Index];
			shiftDown(stack3Index);
			stack3Index--;
			break;
		default:
			throw new Exception("Invalid stack id. Choose values between 1 - 3");
		}
		
		return outElement;
	}

	
	public int top(int stack) throws IndexOutOfBoundsException, Exception {
		switch(stack) {
		case 1:
			if(stack1Index == -1) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack1Index];
		case 2:
			if(stack2Index == -1 || (stack2Index == stack1Index)) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack2Index];
		case 3:
			if(stack3Index == -1 || (stack3Index == stack2Index)) {
				throw new IndexOutOfBoundsException();
			}
			return arr[stack3Index];
		default:
			throw new Exception("Invalid stack id. Choose values between 1 - 3");
		}
	}

	public static void main(String[] args) throws IndexOutOfBoundsException, Exception {
		int size = 5;
		
		UseSingleArrayToImplementThreeStacks stack = new UseSingleArrayToImplementThreeStacks(size);
		stack.push(1, 1);
		stack.push(2, 1);
		System.out.println(stack.top(1));
		stack.push(3, 1);
		stack.push(1, 2);
		System.out.println(stack.top(2));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(2));
		stack.push(2, 2);
		stack.push(3, 2);
		stack.push(1, 3);
		stack.push(2, 3);
		System.out.println(stack.pop(3));
		System.out.println(stack.pop(3));
		stack.push(3, 3);
		stack.push(4, 3);
		System.out.println(stack.pop(3));
		System.out.println(stack.top(3));
	}
}
