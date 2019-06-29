package stack.calculator;

import java.util.Stack;

public class Q227_Basic_Calculator_II {

    public int calculate(String s) {
        char[] ss = s.replaceAll("\\s+", "").toCharArray();
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                int num = ss[i] - '0';
                while (i + 1 < ss.length && Character.isDigit(ss[i + 1])) {
                    num = num * 10 + ss[i + 1] - '0';
                    i++;
                }
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*') stack.push(stack.pop() * num);
                if (op == '/') stack.push(stack.pop() / num);
            } else {
                op = ss[i];
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

}
