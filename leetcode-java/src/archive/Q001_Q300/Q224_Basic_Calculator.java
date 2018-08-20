package archive.Q001_Q300;

import java.util.Stack;

public class Q224_Basic_Calculator {

    public int calculate(String s) {
        int sum = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                sum += sign * num;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
            }
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            if (s.charAt(i) == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            if (s.charAt(i) == ')') {
                sum = sum * stack.pop() + stack.pop();
            }
        }
        return sum;
    }

}
