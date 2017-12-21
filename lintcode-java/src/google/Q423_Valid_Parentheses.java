package google;

import java.util.Stack;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q423_Valid_Parentheses {

    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() &&
                    (stack.peek() == '[' && c == ']' ||
                            stack.peek() == '{' && c == '}' ||
                            stack.peek() == '(' && c == ')')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
