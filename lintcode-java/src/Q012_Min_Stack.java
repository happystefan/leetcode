import java.util.Stack;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q012_Min_Stack {

    public class MinStack {

        Stack<Integer> stacka, stackb;

        public MinStack() {
            // do intialization if necessary
            stacka = new Stack();
            stackb = new Stack();
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            stacka.push(number);
            int min = number;
            if (!stackb.isEmpty()) min = Math.min(min, stackb.peek());
            stackb.push(min);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            stackb.pop();
            return stacka.pop();
        }

        /*
         * @return: An integer
         */
        public int min() {
            // write your code here
            return stackb.peek();
        }
    }

}
