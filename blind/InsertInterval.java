package blind;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] output = new int[intervals.length+1][2];
        int idx = 0;
        int opIdx = 0;
        while(idx < intervals.length && intervals[idx][1] < newInterval[0]){
            output[opIdx] = intervals[idx];
            opIdx++;
            idx++ ;
        }

        while(idx < intervals.length && intervals[idx][0] <= newInterval[1]){
            System.out.println(intervals[idx][1]);
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }


        output[opIdx] = newInterval;
        opIdx++;
        
        while(idx < intervals.length && intervals[idx][0] > newInterval[1]){
            output[opIdx] = intervals[idx];
            opIdx++;
            idx++ ;
        }
        
        int[][] result = new int[opIdx][2];
        for(int i=0; i<opIdx; i++){
            result[i] = output[i];
        }
        return result;
    }

    
    public static void main(String[] args){
        System.out.println("\n 57. Insert Interval");

    }
    
}
