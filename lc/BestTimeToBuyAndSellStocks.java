import java.util.*;

public class BestTimeToBuyAndSellStocks {

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE, maxProf = 0;
        for(int i=0; i<prices.length; i++){

            if(prices[i] - minPrice > maxProf){
                 maxProf = prices[i] - minPrice;
            }
            if(prices[i]< minPrice){
                minPrice = prices[i];
            }
        }
        return maxProf;
    }
    public static void main(String[] args){
        System.out.println("\n121. Best Time to Buy and Sell Stock\n");
        int[] stockPrices = new int[]{7,6,4,3,1};
        System.out.println(Arrays.toString(stockPrices));
        System.out.println("\nMaximum Profit: " + maxProfit(stockPrices));
    }
}