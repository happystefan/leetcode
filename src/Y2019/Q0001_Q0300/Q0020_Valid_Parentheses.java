package Y2019.Q0001_Q0300;

import java.util.Stack;

public class Q0020_Valid_Parentheses {

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isMatch(char a, char b) {
        String str = "()[]{}";
        return str.indexOf(a) + 1 == str.indexOf(b);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isLeft(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: replace (TME)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isValid_replace(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s.replace("()", "");
            s.replace("[]", "");
            s.replace("{}", "");
        }
        return s.length() == 0;
    }

}
