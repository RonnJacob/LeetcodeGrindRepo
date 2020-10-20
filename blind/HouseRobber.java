package blind;

public class HouseRobber {
    public static int rob(int[] nums){
        int[] houses = new int[nums.length+1];
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        houses[0] = 0;
        houses[1] = nums[0];
        for(int i=1; i<nums.length; i++){
            houses[i+1] = Math.max(houses[i], houses[i-1]+nums[i]);
        }
        return houses[nums.length];
    }
    public static void main(String[] args){
        System.out.println("\n 198. House Robber");
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
    
}
