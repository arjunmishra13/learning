package misc.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPracticeHackerRank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String>people = new LinkedList<String>();
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            
            /*
             *  \\w - alpha numeric 1 or more times 
             *  followed by a possible .(period) 
             *  followed by 0 or more alpha numeroc 
             *  followed by @gmail exact match 
             *  followed by .(period) match 
             *  followed by com exact match
             */
            String regEx = "^\\w+(\\.)?\\w*@gmail\\.com$";

            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(emailID);
            
            if(m.find()) {
                people.add(firstName);
            }
        }
        
        Collections.sort(people);
        for(String s:people) {
            System.out.println(s);
        }
    }
}

