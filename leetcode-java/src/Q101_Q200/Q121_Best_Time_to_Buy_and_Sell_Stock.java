package Q101_Q200;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        Queue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!queue.isEmpty()) {
                ans = Math.max(ans, prices[i]-queue.peek());
            }
            queue.add(prices[i]);
        }
        return ans;
    }

}
