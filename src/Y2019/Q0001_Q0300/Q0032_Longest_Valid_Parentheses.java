package Y2019.Q0001_Q0300;

import java.util.Stack;

public class Q0032_Longest_Valid_Parentheses {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int longestValidParentheses_stack(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int result = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') stack.push(i);
            else {
                if (!stack.isEmpty() && ss[stack.peek()] == '(') {
                    stack.pop();
                    int pos = stack.isEmpty() ? -1 : stack.peek();
                    result = Math.max(result, i - pos);
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: greedy
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        String rs = new StringBuilder(s).reverse().toString();
        return Math.max(longestValidParentheses(s.toCharArray(), ')'),
                longestValidParentheses(rs.toCharArray(), '('));
    }

    private int longestValidParentheses(char[] ss, char rchar) {
        int result = 0;
        int l = 0, r = 0;
        int cnt = 0;
        while (r < ss.length) {
            if (ss[r++] == rchar) {
                cnt--;
                if (cnt == 0) result = Math.max(result, r - l);
                if (cnt < 0) {
                    l = r;
                    cnt = 0;
                }
            } else {
                cnt++;
            }
        }
        return result;
    }

}
