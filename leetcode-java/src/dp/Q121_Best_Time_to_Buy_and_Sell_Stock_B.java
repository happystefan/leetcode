package dp;

public class Q121_Best_Time_to_Buy_and_Sell_Stock_B {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, price-min);
        }
        return result;
    }

}
