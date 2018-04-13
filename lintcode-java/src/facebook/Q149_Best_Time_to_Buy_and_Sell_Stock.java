package facebook;

public class Q149_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(prices[i]-min, result);
            min = Math.min(prices[i], min);
        }
        return result;
    }

}
