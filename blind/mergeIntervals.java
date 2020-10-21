package blind;

import java.util.*;
public class mergeIntervals {

    public static int[][] merge(int[][] intervals){
        Collections.sort(Arrays.asList(intervals), ((a,b)->Integer.compare(a[0], b[0])));

        LinkedList<int[]> ll = new LinkedList<>();
        for(int[] interval: intervals){
            if(ll.isEmpty() || ll.getLast()[1] < interval[0]){
                ll.add(interval);
            }
            else{
                int[] last = ll.removeLast();
                ll.add(new int[]{Math.min(last[0], interval[0]), Math.max(last[1], interval[1])});
            }
        }
        
        return ll.toArray(new int[ll.size()][2]);
    }

    public static void main(String[] args){
        System.out.println("\n 56. Merge Intervals");
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15, 18}};
        System.out.print(Arrays.deepToString(merge(intervals)));

    }
    
}
