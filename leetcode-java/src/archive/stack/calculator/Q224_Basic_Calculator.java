package archive.stack.calculator;

import java.util.*;

public class Q224_Basic_Calculator {

    public int calculate(String s) {
        char[] ss = s.replaceAll("\\s+", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int sum = 0, sign = 1;
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                int num = ss[i]-'0';
                while (i+1 < ss.length && Character.isDigit(ss[i+1])) {
                    num = num*10+ss[i+1]-'0';
                    i++;
                }
                sum += sign*num;
            } else if (ss[i] == '+') {
                sign = 1;
            } else if (ss[i] == '-') {
                sign = -1;
            } else if (ss[i] == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (ss[i] == ')') {
                sum = sum*stack.pop() + stack.pop();
            }
        }
        return sum;
    }

}
