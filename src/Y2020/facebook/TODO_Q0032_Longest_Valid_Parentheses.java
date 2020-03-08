package Y2020.facebook;

public class TODO_Q0032_Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            if (ss[i] == '(' && ss[i + 1] == ')') dp[i][i + 1] = 1;
        }
        for (int i = 0; i < n -1; i++) {

        }
    }

}
