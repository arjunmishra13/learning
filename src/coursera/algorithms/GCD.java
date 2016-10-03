package coursera.algorithms;

/**
 * 
 * @author amishra
 *Trick is to use Key Lemma
 *If a' is the remainder of when a/b
 *then gcd(a,b) = gcd(a',b) = gcd(b,a')
 *Calculate recursively 
 */
public class GCD {

	private GCD() {
		
	}
	
	public int getGCD(int a, int b) {
		if(b==0) {
			return a;
		} else if(a%b == 0) {
			return b;
		}
		
		int remainder = a%b;
		return getGCD(b,remainder);
	}
	
	public static void main(String[] args) {
		
		GCD gcd = new GCD();
		System.out.println(gcd.getGCD(27431936,11572848));
	}
}
