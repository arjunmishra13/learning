package misc.problems;

import java.util.Scanner;

public class PrintACount {

    public static void printACount(String s, long n) {
        
        int[]aCount = new int[s.length()];
        int currentCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                currentCount++;
            }
            aCount[i] = currentCount;
        }
        long numberOfAs = 0l;

        long quotient = n/(long)s.length();
        int remainder = (int) (n%s.length());
        
        numberOfAs = quotient*aCount[s.length() - 1] + (remainder > 0?aCount[remainder - 1]:0);
        
        System.out.println(numberOfAs);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        printACount(s, n);
    }
}

