package dp.stock;

public class Q714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];
        int[] empty = new int[n];
        hold[0] = -prices[0];
        empty[0] = 0;
        for (int j = 1; j < n; j++) {
            hold[j] = Math.max(hold[j-1], empty[j-1]-prices[j]);
            empty[j] = Math.max(empty[j-1], hold[j-1]+prices[j]-fee);
        }
        return empty[n-1];
    }
    /*
    public int maxProfit(int[] prices, int fee) {
             int profit = 0, invest = -prices[0];
             for (int i = 1; i < prices.length; i++) {
                 profit = Math.max(profit, invest+prices[i]-fee);
                 invest = Math.max(invest, profit-prices[i]);
             }
             return profit;
         }

     */

}
