package archive.Q001_Q300;

import java.util.Stack;

public class Q227_Basic_Calculator_II_B {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i)-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10+s.charAt(i+1)-'0';
                    i++;
                }
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*') stack.push(stack.pop()*num);
                if (op == '/') stack.push(stack.pop()/num);

            } else if (s.charAt(i) != ' ') op = s.charAt(i);
        }
        int ans = 0;
        while (!stack.isEmpty()) ans += stack.pop();
        return ans;
    }

}
