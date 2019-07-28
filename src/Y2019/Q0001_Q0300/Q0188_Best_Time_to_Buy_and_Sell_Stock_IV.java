package Y2019.Q0001_Q0300;

public class Q0188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] call = new int[n];
        int[] sell = new int[n];
        call[0] = -prices[0];
        sell[0] = 0;
        k = Math.min(k, n / 2);
        while (k-- > 0) {
            for (int i = 1; i < n; i++) {
                call[i] = Math.max(call[i - 1], sell[i - 1] - prices[i]);
            }
            for (int i = 1; i < n; i++) {
                sell[i] = Math.max(sell[i - 1], call[i - 1] + prices[i]);
            }
        }
        return sell[n - 1];
    }

}
