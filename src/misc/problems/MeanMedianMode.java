package misc.problems;

import java.io.*;
import java.util.*;

public class MeanMedianMode {

    private class Statistics {
        double mean;
        double median;
        int mode;
        
        void setMean(double mean) {
            this.mean = mean;
        }
        
        void setMedian(double median) {
            this.median = median;
        }
        
        void setMode(int mode) {
            this.mode = mode;
        }
        
        double getMean() {
            return mean;
        }
        
        double getMedian() {
            return median;
        }
        
        double getMode() {
            return mode;
        }
        
        void print() {
            System.out.println(mean + "\n" + median + "\n" + mode);
        }
    }

    private Statistics stats;

    public MeanMedianMode() { 
        stats = new Statistics();
    }
    
    public void evaluateStats(int[]arr) {
        
        if(arr.length == 0) {
            stats.setMean(0.0);
            stats.setMedian(0.0);
            stats.setMode(0);
            return;
        }
        
        Map<Integer, Integer>modeMap = new HashMap<Integer, Integer>();
        Arrays.sort(arr);
        double mean = 0.0, median = 0.0;
        int mode = 0;
        for(int i = 0; i < arr.length; i++) {
            mean += arr[i];
            
            if(!modeMap.containsKey(arr[i])) {
                modeMap.put(arr[i], 0);
            }
               
            modeMap.put(arr[i], modeMap.get(arr[i]) + 1);
        }
               
        mean = (double)mean/(double)arr.length;
        stats.setMean(mean);
        if(arr.length%2 != 0) {
            median = arr[arr.length/2 - 1];
        } else {
            median = (double)(arr[arr.length/2 - 1] + arr[arr.length/2])/(double)2;
        }
               
        stats.setMedian(median);
               
        int minMode = 0;
        for(int m: modeMap.keySet()) {
            if(minMode == 0 || minMode < modeMap.get(m)) {
                minMode = modeMap.get(m);
                mode = m;
            } else if(minMode == modeMap.get(m) && mode > m){
                mode = m;
            }
        }
               
        stats.setMode(mode);
    }
    
    public Statistics getStats() {
        return stats;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]arr = new int[size];
        int index = 0;
        while(index < size) {
            arr[index] = sc.nextInt();
            index++;
        }
        
        MeanMedianMode solutionObj = new MeanMedianMode(); 
        solutionObj.evaluateStats(arr);
        solutionObj.getStats().print();
    }
}