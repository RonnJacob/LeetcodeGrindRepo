package blind;

public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
       
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int targetPtr = 1; targetPtr <= target; targetPtr++){
            for(int i=0; i<nums.length; i++){
                if(nums[i] <=targetPtr){
                    dp[targetPtr] += dp[targetPtr-nums[i]];
                } 
            }
        }     
        return dp[target];
    }
    public static void main(String[] args){
        System.out.println("\n Hello World\n");

        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));

    }
    
}
