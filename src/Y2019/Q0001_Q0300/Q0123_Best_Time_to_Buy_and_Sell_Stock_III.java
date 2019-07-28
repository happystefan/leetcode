package Y2019.Q0001_Q0300;

public class Q0123_Best_Time_to_Buy_and_Sell_Stock_III {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int[] call = new int[n];
            int[] sell = new int[n];
            call[0] = -prices[0];
            sell[0] = 0;
            int k = Math.min(2, n / 2);
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

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int maxProfit(int[] prices) {
            int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
            int s1 = 0, s2 = 0;
            for (int p : prices) {
                b1 = Math.max(b1, -p);
                s1 = Math.max(s1, b1 + p);
                b2 = Math.max(b2, s1 - p);
                s2 = Math.max(s2, b2 + p);
            }
            return s2;
        }

    }


}
