public class CoinChange {

    // You have a function 
    // Say F(S) = F(S-c1) + 1

    // when F(S) = 0 we have return 0
    // when F(S) = -1 when n = 0;
    
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] count){

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        if(count[amount-1] != 0) return count[amount-1];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res = coinChange(coins, amount-coins[i], count);
            if(res < min && res >=0){
                min = res + 1;
            }
        }

        count[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[amount-1];
    }

    public static void main(String[] args){
        System.out.println("\n322. Coin Change");
        int[] coins = new int[]{1, 2, 3};
        int amount = 3;
        CoinChange sol = new CoinChange();
        if(sol.coinChange(coins, amount)!=-1){
            System.out.println(coins.length*coins);
        }

    }
    
}
