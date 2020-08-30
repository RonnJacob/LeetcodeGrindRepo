import java.util.*;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), (a,b)-> Integer.compare(a[0],b[0]));

        if(intervals.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));

        pq.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] peekaboo = pq.peek();
            if(intervals[i][0]>= peekaboo[1]){
                pq.poll();
                pq.offer(intervals[i]);
            }
            else{
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }

    public static void main(String[] args){
        System.out.println("\n253. Meeting Rooms II");
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = new int[][]{{7,10}, {2,4}};
        int[][] intervals3 = new int[][]{{1, 10}, {2, 7}, {3, 19},{8,12},{10, 20}, {11, 30}};
        System.out.println(minMeetingRooms(intervals3));    

    }
    
}

/*

So we're going to first sort each intervals.

Then add each of the intervals into a priority queue with two conditions.

- Peek and check the top of the PQ and compare times. If start of the new interval is greater than the end of the peeked interval.
POP AND ADD THE NEW INTERVAL
- Otherwise, add it to the heap.

Return the size of the heap.
*/