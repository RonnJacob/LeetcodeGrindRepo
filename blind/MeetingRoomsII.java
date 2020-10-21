package blind;

import java.util.*;
public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals){

        Collections.sort(Arrays.asList(intervals), ((a,b)->Integer.compare(a[0], b[0])));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));

        for(int[] interval: intervals){
            if(pq.isEmpty() || pq.peek()[1]>interval[0]){
                pq.add(interval);
            }
            else{
                pq.poll();
                pq.add(interval);
            }
        }

        return pq.size();
    }
    public static void main(String[] args){
        System.out.println("\n 253. Meeting Rooms II");
        int[][] intervals = new int[][]{{2,4}, {7, 10}, {9, 16}};
        System.out.println(minMeetingRooms(intervals));
    } 
    
}
