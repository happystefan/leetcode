package Q001_Q300;

import java.util.Stack;

public class Q232_Implement_Queue_using_Stacks {

    class MyQueue {

        Stack<Integer> stack1, stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!stack2.isEmpty()) stack1.add(stack2.pop());
            stack2.add(x);
            while (!stack1.isEmpty()) stack2.add(stack1.pop());
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}

