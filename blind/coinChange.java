package blind;

public class coinChange {

    public static int coinChangeMethod(int[] coins, int amount){
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        System.out.println("\n322. Coin Change");
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChangeMethod(coins, amount));

        // 11-5  1 + coinchange(coins, 6)
        // 6-5
    }
    
}


// coins[0] = 0
// coins[1] = 1
// coins[2] = 1
// coins[3] = 1 + 1
// coins[4] = 1 + 1
// coins[5] = 
