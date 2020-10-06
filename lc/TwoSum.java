import java.util.*;
public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numsTally = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numsTally.containsKey(target-nums[i])){
                return new int[]{numsTally.get(target-nums[i]),i};
            }
            else{
                numsTally.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("Cannot find solution");
    }

    public static void printArray(int[] nums){
        System.out.println();
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("\n1. Two Sum");
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        printArray(nums);
        printArray(twoSum(nums, target));
        
    }
    
}