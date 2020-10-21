package blind;

import java.util.*;
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals){
        Collections.sort(Arrays.asList(intervals), ((a,b)->Integer.compare(a[0], b[0])));
        if(intervals.length == 0){
            return 0;
        }

        int prev = 0;
        int count = 0;
        for(int i=1;  i<intervals.length; i++){
            if(intervals[prev][1] > intervals[i][0]){

                // We pick the shorter interval to be the interval that we're kicking out.
                if(intervals[prev][1] > intervals[i][1]){
                    prev = i;
                }
                count++;
            }
            else{
                prev = i;
            }

        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("\n Non Overlapping Intervals");
        int[][] intervals = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals2 = new int[][]{{1,2}, {2,3}};
        System.out.println(eraseOverlapIntervals(intervals2));
    }
    
}
