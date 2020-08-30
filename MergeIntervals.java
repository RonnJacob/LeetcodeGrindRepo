import java.util.*;
public class MergeIntervals {

    public static int[][] merge(int[][] intervals){
        Collections.sort(Arrays.asList(intervals), (a,b)-> Integer.compare(a[0], b[0]));

        
        LinkedList<int[]> result = new LinkedList<>();
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0] > intervals[i][1]){
                return new int[][]{};
            }
            if(result.isEmpty()){
                result.add(intervals[i]);
            }
            else{
                int[] lastAddedInterval = result.getLast();
                // Check if the current interval is less than the end of the previous interval.@interface

                //5,10 - last added  | 8,9 - current | No need to do anything

                // 5,10 - last added | 8,11 - current | update last one
                if(intervals[i][0] <= lastAddedInterval[1] && intervals[i][1]> lastAddedInterval[1]){
                    result.removeLast();
                    result.add(new int[]{lastAddedInterval[0], intervals[i][1]});
                }

                // Disjoint interval
                if(intervals[i][0] > lastAddedInterval[1]){
                    result.add(intervals[i]);
                }
            }
        }

        int[][] resultArr = new int[result.size()][2];
        int k=0;
        for(int i=0; i<result.size(); i++){
            resultArr[k++] = result.get(i); 
        }

        return resultArr;
    }

    public static void main(String[] args){
        System.out.println("\n56. Merge Intervals");
        int[][] intervals = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] intervals2 = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals3 = new int[][]{{1,4},{4,5}};

        int[][] result = merge(intervals);
        int[][] result2 = merge(intervals2);
        int[][] result3 = merge(intervals3);


        System.out.println("\nMerged Intervals - Example 1");
        for(int i=0; i<result.length; i++){
            System.out.println(result[i][0] + "," + result[i][1]);
        }

        System.out.println("\nMerged Intervals - Example 2");
        for(int i=0; i<result2.length; i++){
            System.out.println(result2[i][0] + "," + result2[i][1]);
        }

        System.out.println("\nMerged Intervals - Example 3");
        for(int i=0; i<result3.length; i++){
            System.out.println(result3[i][0] + "," + result3[i][1]);
        }
    }
}