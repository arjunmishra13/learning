package misc.problems;

import java.util.Scanner;

public class NumberOfCamelCaseWords {

    private static boolean isUpperCase(char c) {
        return ((int)c >= 65 && (int)c <= 90);
    }
    
    public static int numberOfWords(String str) {
    	
    	if(isUpperCase(str.charAt(0))) {
    		return 0;
    	}
    	int numberOfWords = 1;
    	for(int i = 1; i < str.length(); i++) {
    		
    		if(isUpperCase(str.charAt(i))) {
    			numberOfWords++;
    		}
    	}
    	return numberOfWords;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(numberOfWords(s));
    }
}

