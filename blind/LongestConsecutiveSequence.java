package blind;

import java.util.*;
import java.util.stream.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveMethod(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        if(nums.length  == 1){
            return 1;
        }
        
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestStreak = 0;
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                int currStreak = 1;
                int currNum = num+1;
                while(numSet.contains(currNum)){
                    currStreak ++;
                    currNum ++;
                }
                longestStreak  = Math.max(longestStreak, currStreak);
            }
        }
        System.out.println(longestStreak);
        return longestStreak;
    }
    public static void main(String[] args){
        System.out.println("\n128. Longest Consecutive Sequence");
        int[] nums = new int[]{100, 4, 200, 1, 52, 20};
        longestConsecutiveMethod(nums);
    }
    


}
