package Y2019.Q0001_Q0300;

import java.util.Arrays;

public class Q0132_Palindrome_Partitioning_II {

    public int minCut(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalindrome[i][i] = true;
        for (int i = 1; i < n; i++) isPalindrome[i - 1][i] = ss[i - 1] == ss[i];
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                isPalindrome[i][j] = ss[i] == ss[j] && isPalindrome[i + 1][j - 1];
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (isPalindrome[j][i]) dp[i] = Math.min(dp[i], dp[j - 1] + 1);
            }
        }
        return dp[n - 1];
    }

}
