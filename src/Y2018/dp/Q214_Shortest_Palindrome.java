package Y2018.dp;

public class Q214_Shortest_Palindrome {

    // Time Limit Exceed
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n && ss[i] == ss[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                dp[i][j] = dp[i + 1][j - 1] && ss[i] == ss[j];
            }
        }
        if (dp[0][n - 1]) {
            return s;
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                idx = i;
            }
        }
        return new StringBuilder(s.substring(idx + 1)).reverse().toString() + s;
    }

}
