package misc.problems;

import java.text.ParseException;
import java.util.Scanner;

public class DayOfTheProgrammer {

    public static final int DAY_OF_THE_PROGRAMMER = 256;
    public enum Style {
    	JULIAN, INTERMEDIATE, GREGORIAN;
    }
    
    public static String getDayOfTheProgrammer(int year) throws ParseException {
    	Style style = null;
    	
        if(year < 1918) {
        	style = Style.JULIAN;
        } else if(year == 1918) {
        	style = Style.INTERMEDIATE;
        } else {
        	style = Style.GREGORIAN;
        	
        }
        
        int month = 1;
        int date = 0;
        while(month <= 12) {
        	int temp = date;
        	date += getDay(month, year, style);
        	
        	if(date > 256) {
        		date = 256 - temp;
        		break;
        	}
        	month++;
        }
        
        return String.format("%s.%s.%s", getString(date, 2), getString(month, 2), getString(year, 4));
    }
    
    private static String getString(int num, int length) {
    	String str = String.format("%d", num);
    	
    	while(str.length() < length) {
    		str = "0" + str;
    	}
    	return str;
    }
    private static int getDay(int month, int year, Style style) {
    	
    	switch(month) {
    	case 1:
    	case 3:
    	case 5:
    	case 7:
    	case 8:
    	case 10:
    	case 12:
    		return 31;
    	case 4:
    	case 6:
    	case 9:
    	case 11:
    		return 30;
    	case 2:
    		if( isLeapYear(year, style) ) {
    			return 29;
    		} else if( style == Style.INTERMEDIATE){
    			return 15;
    		} else {
    			return 28;
    		}
		default:
    		return 0;	
    	}
    }
    
    private static boolean isLeapYear(int year, Style style) {
    	if(style == Style.GREGORIAN) {
    		return (year%400 == 0 || (year%400 != 0 && year%4 == 0));
    	} else if(style == Style.JULIAN) {
    		return year%4 == 0;
    	} 
    	
    	return false;
    }
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        // your code goes here
        System.out.println(getDayOfTheProgrammer(y));
    }
}

