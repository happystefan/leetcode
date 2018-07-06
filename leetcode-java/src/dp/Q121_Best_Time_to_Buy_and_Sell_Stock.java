package dp;

public class Q121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    result = Math.max(result, prices[j]-prices[i]);
                }
            }
        }
        return result;
    }

}
