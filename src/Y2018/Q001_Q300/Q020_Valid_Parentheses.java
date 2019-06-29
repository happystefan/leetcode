package Y2018.Q001_Q300;

import java.util.Stack;

/**
 * Created by mqliang on 5/31/17.
 */
public class Q020_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() &&
                    (stack.peek() == '(' && c == ')' || stack.peek() == '{' && c == '}' || stack.peek() == '[' && c == ']')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
