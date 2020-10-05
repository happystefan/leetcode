package Y2020.linkedin.algo_part1;

public class Q026_Maximum_Length_Palindromic_Subsequence {

    int max_len_palindromic_subseq(char[] vals) {
        if (vals == null || vals.length == 0) return 0;
        int[][] dp = new int[vals.length][vals.length];
        for (int i = 0; i < vals.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i + 1 < vals.length; i++) {
            if (vals[i] == vals[i + 1]) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }
        for (int l = 2; l < vals.length; l++) {
            for (int i = 0; i + l < vals.length; i++) {
                int j = i + l;
                if (vals[i] == vals[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][vals.length - 1];
    }

    int max_len_palindromic_substr(char[] vals) {
        if (vals == null || vals.length == 0) return 0;
        boolean[][] dp = new boolean[vals.length][vals.length];

        int rslt = 1;
        for (int i = 0; i < vals.length; i++) {
            dp[i][i] = true;
            if (i + 1 < vals.length && vals[i] == vals[i + 1]) {
                dp[i][i + 1] = true;
                rslt = 2;
            }
        }
        for (int l = 2; l < vals.length; l++) {
            for (int i = 0; i + l < vals.length; i++) {
                int j = i + l;
                if (vals[i] == vals[j] && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                    rslt = Math.max(rslt, j - i + 1);
                }
            }
        }
        return rslt;
    }
}
