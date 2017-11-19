import java.util.Stack;

public class Q155_Min_Stack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.s2.toArray().length);
    }

}

class MinStack {

    Stack<Integer> s1, s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= s2.peek()) s2.push(x);
    }

    public void pop() {
        if (s1.peek().equals(s2.peek())) s2.pop();
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
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
