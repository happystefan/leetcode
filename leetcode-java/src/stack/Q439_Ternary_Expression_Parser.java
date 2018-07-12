package stack;

import java.util.*;

public class Q439_Ternary_Expression_Parser {

    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length()-1; i >=0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char a = stack.pop();
                stack.pop();
                char b = stack.pop();
                if (c == 'T') {
                    stack.push(a);
                } else {
                    stack.push(b);
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.pop());
    }

}
