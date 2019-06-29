package Y2018.vmware;

import java.util.Stack;

public class Q020_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (!isPair(stack.peek(), c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char l, char r) {
        return l == '{' && r == '}' || l == '[' && r == ']' || l == '(' && r == ')';
    }

}
