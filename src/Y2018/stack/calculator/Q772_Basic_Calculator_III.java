package Y2018.stack.calculator;

import java.util.Stack;

public class Q772_Basic_Calculator_III {

    public int calculate(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
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
            } else if (ss[i] == '(') {
                int l = 1;
                int j = i + 1;
                while (j < ss.length && l > 0) {
                    if (ss[j] == '(') l++;
                    else if (ss[j] == ')') l--;
                    j++;
                }
                int num = calculate(s.substring(i + 1, j - 1));
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*') stack.push(stack.pop() * num);
                if (op == '/') stack.push(stack.pop() / num);
                i = j - 1;
            } else if (ss[i] != ' ') {
                op = ss[i];
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

}