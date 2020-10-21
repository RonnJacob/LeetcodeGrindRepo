package blind;


// Let's try to understand LIS.

// DP works on the principle of Mathematical Induction where we've got results
// up to i-1 and we're trying to solve for i.


public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums.length  == 0){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        int ans = 1;
        for(int i=1; i<nums.length; i++){
            int maxVal = 0;
            for(int j = 0; j<i ; j++){
                if(nums[j] < nums[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        return ans;
    }


    public static int lengthofLIS2(int[] nums){
        int[] top  = new int[nums.length];
        int piles = 0;
        for(int i=0; i<nums.length; i++){
            int poker = nums[i];

            int l = 0, r = piles;
            while(l<r){
                int m = (l+r)/2;
                if(top[m] >= poker){
                    r = m;
                }
                else {
                    l = m+1;
                }
            }

            if(l == piles){
                piles++;
            }

            top[l] = poker;
        }
        return piles;
    }
    public static void main(String[] args){
        System.out.println("\n 300. Longest Increasing Subsequence");
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthofLIS2(nums));
    }
    
}
