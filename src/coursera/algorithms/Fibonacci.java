package coursera.algorithms;

import java.math.BigInteger;
import java.util.Vector;

/**
 * 
 * @author amishra
 *
 *Trick is to not use recurssion because you will be double calculating 
 *Use an Array
 */
public class Fibonacci {

	public BigInteger result;
	public Vector<BigInteger> fib = new Vector<BigInteger>();
	private Fibonacci(int n) {
		
		for(int i=0;i<=n;i++) {
			if(i < 2) {
				fib.add(BigInteger.valueOf(i));
			} else if(i ==2) {
				fib.add(BigInteger.ONE);
			} else {
				fib.add(fib.get(i-1).add(fib.get(i-2)));
			}
		}
		
		result = fib.get(n);
	}
		
	public static void main(String[] args) {
		
		Fibonacci fib = new Fibonacci(1000);
		System.out.println(fib.result);
	}
}
