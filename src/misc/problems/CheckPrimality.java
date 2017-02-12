package misc.problems;

public class CheckPrimality {

	public static boolean isPrime(int num) {
		num = Math.abs(num);
		if( num < 2) {
			return false;
		}
		
		int sqrtNum = (int)Math.sqrt(num*1.0);
		for(int i = 2;i<= sqrtNum; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int n = (int)(Math.random()*1000);
		
		System.out.println("Is prime\t" +  n + "\t" + isPrime(n));
	}
}
