package misc.problems;

import java.util.Scanner;

public class SuperReducedString {

    public static String compressString(String str) {
        
        int currentIndex = 0;
        while(currentIndex < str.length()) {
            if(currentIndex < str.length() - 1 && str.charAt(currentIndex) == str.charAt(currentIndex + 1)) {
            	String temp = str.substring(0, currentIndex);
            	if(currentIndex < str.length() - 2) {
            		temp += str.substring(currentIndex + 2);
            	}
                str = temp;
                currentIndex = 0;
            } else {
            	currentIndex++;
            	
            }
        }
        
        return str.length() == 0 ?"Empty String":str;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        System.out.println(compressString(str));
    }
}