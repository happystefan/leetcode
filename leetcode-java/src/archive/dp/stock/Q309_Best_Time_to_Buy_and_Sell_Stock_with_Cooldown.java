package archive.dp.stock;

public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];
        int[] empty = new int[n];
        hold[0] = -prices[0];
        empty[0] = 0;
        /*
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                hold[i] = Math.max(-prices[i], hold[i-1]);
            } else {
                hold[i] = Math.max(hold[i-1], empty[i-2]-prices[i]);
            }
            empty[i] = Math.max(empty[i-1], hold[i-1]+prices[i]);
        }
        */
        for (int i = 0; i < n/2; i++) {
            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    hold[j] = Math.max(-prices[j], hold[j-1]);
                } else {
                    hold[j] = Math.max(hold[j-1], empty[j-2]-prices[j]);
                }
            }
            for (int j = 1; j < n; j++) {
                empty[j] = Math.max(empty[j-1], hold[j-1]+prices[j]);
            }
        }
        return empty[n-1];
    }

}
