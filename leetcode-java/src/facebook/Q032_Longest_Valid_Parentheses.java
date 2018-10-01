package facebook;

import java.util.*;

public class Q032_Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') stack.push(i);
            else {
                if (!stack.isEmpty() && ss[stack.peek()] == '(') {
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