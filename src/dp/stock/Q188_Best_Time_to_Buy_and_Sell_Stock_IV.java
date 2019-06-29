package dp.stock;

public class Q188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        if (k > n / 2) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
            }
            return result;
        }

        int[] hold = new int[n];
        int[] empty = new int[n];
        hold[0] = -prices[0];
        empty[0] = 0;
        for (int i = 0; i < Math.min(k, n / 2); i++) {
            for (int j = 1; j < n; j++) {
                hold[j] = Math.max(hold[j - 1], empty[j - 1] - prices[j]);
            }
            for (int j = 1; j < n; j++) {
                empty[j] = Math.max(empty[j - 1], hold[j - 1] + prices[j]);
            }
        }
        return empty[n - 1];
    }

}
