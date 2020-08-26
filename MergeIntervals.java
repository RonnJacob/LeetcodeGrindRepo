import java.util.*;
public class MergeIntervals {

    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0 || intervals.length == 1){
            return intervals;
        }

        int[][] result = new int[][]{};
        Map<int[], Integer> intervalLast = new HashMap<>();
        for(int i=0; i<intervals.length; i++){
            intervalLast.put(intervals[i], intervals[i][1]);
            // System.out.println(intervals[i][1]);
        }


        int lastIndexBiggest = intervalLast.get(intervals[0]);
        int k=1;
        for(int i=0; i<intervals.length; i++){
            lastIndexBiggest = Math.max(lastIndexBiggest, intervalLast.get(intervals[i]));
            if(i==lastIndexBiggest){
                System.out.println(k);
                k=0;
            }
            k++;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("\n56. Merge Intervals\n");
        int[][] intervals = new int[][] {{1,3}, {2,6}, {8, 10}, {15, 18}};
        merge(intervals);
    }
    
}