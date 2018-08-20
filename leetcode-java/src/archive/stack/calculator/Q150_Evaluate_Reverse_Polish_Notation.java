package archive.stack.calculator;

import java.util.*;

public class Q150_Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b-a);
            } else if (token.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
