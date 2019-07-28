package Y2019.Q0001_Q0300;

public class Q0122_Best_Time_to_Buy_and_Sell_Stock_II {

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
            int min = Integer.MIN_VALUE;
            int result = 0;
            for (int price : prices) {
                if (price > min) {
                    result += price - min;
                    min = price;
                } else {
                    min = price;
                }
            }
            return result;
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
            if (prices == null || prices.length == 0) return 0;
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
            }
            return result;
        }

    }


}
