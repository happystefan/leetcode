package Y2018.dp.stock;

public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        /*
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            if (price > min) {
                result += price-min;
                min = price;
            } else {
                min = Math.min(min, price);
            }
        }
        return result;
        */
        int n = prices.length;
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
        }
        return result;
    }

}
