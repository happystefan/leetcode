package archive.Q001_Q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q225_Implement_Stack_using_Queues_B {

    class MyStack {

        Queue<Integer> queue1, queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto archive.stack. */
        public void push(int x) {
            Queue<Integer> queue2push, queue2pull;
            if (queue1.isEmpty()) {
                queue2push = queue1;
                queue2pull = queue2;
            } else {
                queue2push = queue2;
                queue2pull = queue1;
            }
            queue2push.add(x);
            while (!queue2pull.isEmpty()) queue2push.add(queue2pull.poll());
        }

        /** Removes the element on top of the archive.stack and returns that element. */
        public int pop() {
            return queue1.isEmpty() ? queue2.poll() : queue1.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue1.isEmpty() ? queue2.peek() : queue1.peek();
        }

        /** Returns whether the archive.stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
