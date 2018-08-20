package archive.Q001_Q300;

import java.util.Stack;

public class Q227_Basic_Calculator_II {

    public int calculate(String s) {
        // eliminate * and / first
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i)-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10+s.charAt(i+1)-'0';
                    i++;
                }
                if (!stack.isEmpty() && stack.peek().equals("*")) {
                    stack.pop();
                    int a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a*num));
                } else if (!stack.isEmpty() && stack.peek().equals("/")) {
                    stack.pop();
                    int a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a/num));
                } else {
                    stack.push(String.valueOf(num));
                }
            }
            if (s.charAt(i) == '+') stack.push("+");
            if (s.charAt(i) == '-') stack.push("-");
            if (s.charAt(i) == '*') stack.push("*");
            if (s.charAt(i) == '/') stack.push("/");
        }

        // calculate + and -
        Stack<String> pmStack = new Stack<>();
        while (!stack.isEmpty()) pmStack.push(stack.pop());
        while (pmStack.size() > 1) {
            int a = Integer.valueOf(pmStack.pop());
            String op = pmStack.pop();
            int b = Integer.valueOf(pmStack.pop());
            if (op.equals("+")) pmStack.push(String.valueOf(a+b));
            else pmStack.push(String.valueOf(b-a));
        }
        return Integer.valueOf(pmStack.pop());
    }

}
