public class Solution121 {
    //Attempt1: 360ms
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) 
            return 0;

        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }   

        return profit;
    }
}