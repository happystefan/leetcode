package dp;

import java.util.Arrays;

public class Q132_Palindrome_Partitioning_II {

    public int minCut(String s) {
        int n = s.length();
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

        int[] cut = new int[n];
        Arrays.fill(cut, Integer.MAX_VALUE);
        cut[0] = 0;
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                cut[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (dp[j][i]) cut[i] = Math.min(cut[i], cut[j - 1] + 1);
            }
        }
        return cut[n - 1];
    }

}
