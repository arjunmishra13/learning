package misc.problems;

public class SumProbability {

	public static double sumProbability(int dice, int target) {
        if(dice < 1) {
            return 0.0;
        }
        
        double totalNumberOfCases = Math.pow(6, dice);
        
        int findNumberOfCases = getCases(dice, target);
        System.out.println(findNumberOfCases + "/" + totalNumberOfCases);
        return (findNumberOfCases/totalNumberOfCases);
    }
    
    private static int getCases(int dice, int target) {
        
        if(target <= 0 && dice > 0) {
            return 0;
        }
        
        if(dice == 1 && target > 6) {
            return 0;
        }
        
        if(dice == 1) {
            return 1;
        }
        
        int numberOfCases = 0;
        for(int i = 1;  i <= 6; i++) {
            numberOfCases += getCases(dice - 1, target - i);
        }
        
        return numberOfCases;
    }
    
    //1-0, 2-0, 
    
    
    public static void main(String[]args) {
        int dice = 2;
        int target = 12;
        
        System.out.println(sumProbability(dice, target));
    }
}
