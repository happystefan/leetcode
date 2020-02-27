package Y2020.facebook;

import java.util.Stack;

public class Q0020_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (isPair(stack.peek(), c)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char a, char b) {
        if (a == '(') return b == ')';
        if (a == '[') return b == ']';
        if (a == '{') return b == '}';
        return false;
    }

}
