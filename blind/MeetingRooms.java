package blind;

import java.util.*;
public class MeetingRooms {


    public static boolean canAttendMeetings(int[][] intervals) {


        PriorityQueue<int[]> hp = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        for(int[] interval: intervals){
            hp.offer(interval);
        }

        int startTime = 0;
        int endTime = 0;
        while(!hp.isEmpty()){
            int[] interval = hp.poll();
            if(interval[0] < endTime){
                return false;
            }
            startTime = interval[0];
            endTime = interval[1];
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("\n 252. Meeting Rooms");
        int[][] intervals = new int[][]{{0,30}, {5, 10}, {15, 20}};
        int[][] intervals2 = new int[][]{{7,10}, {2,4}};
        System.out.println(canAttendMeetings(intervals));

    }
    
}
