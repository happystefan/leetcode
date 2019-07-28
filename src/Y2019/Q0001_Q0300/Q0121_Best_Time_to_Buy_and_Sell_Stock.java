package Y2019.Q0001_Q0300;

public class Q0121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(min, price);
        }
        return result;
    }

}
