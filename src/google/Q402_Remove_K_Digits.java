package google;

import java.util.Stack;

public class Q402_Remove_K_Digits {

    public String removeKdigits(String num, int k) {
        char[] ss = String.valueOf(num).toCharArray();
        k = num.length() - k;
        if (k <= 0) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            while (!stack.isEmpty() && ss[i] < stack.peek() && stack.size() + ss.length - 1 - i >= k) {
                stack.pop();
            }
            stack.push(ss[i]);
        }
        while (stack.size() > k) stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

}
