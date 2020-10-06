public class ClimbingStairs {

    // Staircase.

    // 1. Takes n steps to reach the top.
    // 2. Can climb either 1 or 2 steps.

    // Start from the back and reduce the number.
    // 1 + (n-1)

    // 1 
    // [2] [1 1]
    // [1 1 1] [1 2] [2 1]
    // [1111][121][211][112][22]
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n-1]);
        return dp[n-1];
        
    }
    public static void main(String[] args){
        System.out.println("\n Hello World");
        ClimbingStairs s = new ClimbingStairs();
        s.climbStairs(4);
    }
    
}
