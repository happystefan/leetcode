package archive.Q001_Q300;

import java.util.Stack;

public class Q155_Min_Stack_B {

    class MinStack {

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == min) min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
