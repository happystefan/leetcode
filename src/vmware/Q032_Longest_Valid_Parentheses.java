package vmware;

import java.util.Stack;

public class Q032_Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int pos = stack.isEmpty() ? -1 : stack.peek();
                    result = Math.max(result, i - pos);
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

}
