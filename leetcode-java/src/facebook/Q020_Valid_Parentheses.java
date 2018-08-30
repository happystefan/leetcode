package facebook;

import java.util.*;

public class Q020_Valid_Parentheses {

    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : ss) {
            if (!stack.isEmpty() && match(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char a, char b) {
        return a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']';
    }

}
