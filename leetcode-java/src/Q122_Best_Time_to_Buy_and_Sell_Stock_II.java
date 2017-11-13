public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) ans += prices[i+1]-prices[i];
        }
        return ans;
    }
    
}
