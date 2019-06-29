package google;

import java.util.Stack;

public class Q155_Min_Stack {

    class MinStack {

        Stack<Integer> stacka = new Stack<>();
        Stack<Integer> stackb = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stacka.push(x);
            if (stackb.isEmpty() || x < stackb.peek()) stackb.push(x);
            else stackb.push(stackb.peek());
        }

        public void pop() {
            stacka.pop();
            stackb.pop();
        }

        public int top() {
            return stacka.peek();
        }

        public int getMin() {
            return stackb.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
