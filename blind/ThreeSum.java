package blind;
import java.util.*;
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length && nums[i] <= 0 ; i++){
            if(i==0 || nums[i-1] != nums[i]){
                twoSum(nums, i, result);
            }
        }
        return result;
    }
    public static void twoSum(int[] nums, int i, List<List<Integer>> result){
        int low = i+1;
        int high = nums.length-1;
        while(low < high){
            int sum = nums[i] + nums[low] + nums[high];
            if(sum < 0){
                ++low;
            }
            else if(sum > 0){
                --high;
            }
            else{
                System.out.println(nums[low] + " : " + nums[high] + " : " + nums[i]);
                result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low-1]){
                    ++low;
                }

            }
        }
    }
    public static void main(String[] args){
        System.out.println("\n 3 Sum");
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
    
}
