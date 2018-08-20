package archive.dp;

public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] sell= new int[n+1];
        buy[0] = -prices[0];
        sell[0]= 0;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                buy[i] = Math.max(-prices[i], buy[i-1]);
            } else {
                buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            }
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[n-1];
    }

}
