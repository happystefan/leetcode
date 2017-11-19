package Q101_Q200;

public class Q121_Best_Time_to_Buy_and_Sell_Stock_B {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i]-min);
        }
        return ans;
    }

}
