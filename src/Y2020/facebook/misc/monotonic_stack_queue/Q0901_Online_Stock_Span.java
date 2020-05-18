package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Stack;

public class Q0901_Online_Stock_Span {

    class StockSpanner {

        Stack<int[]> stack = new Stack<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int rslt = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                rslt += stack.pop()[1];
            }
            stack.push(new int[]{price, rslt});
            return rslt;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

}
