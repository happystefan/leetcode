package dp;

public class Q714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0, invest = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, invest + prices[i] - fee);
            invest = Math.max(invest, profit - prices[i]);
        }
        return profit;
    }

}
