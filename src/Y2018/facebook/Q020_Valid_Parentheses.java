package Y2018.facebook;

import java.util.Stack;

public class Q020_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && isPair(stack.peek(), c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char a, char b) {
        String ab = "" + a + b;
        return ab.equals("()") || ab.equals("[]") || ab.equals("{}");
    }

}
