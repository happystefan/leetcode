package Y2019.Q0001_Q0300;

import java.util.Arrays;

public class Q0096_Unique_Binary_Search_Trees {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs with memory
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int numTrees_dfs(int n) {
        if (n == 0) return 0;
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);
        return dfs(1, n, memo);
    }

    private int dfs(int l, int r, int[][] memo) {
        if (l >= r) return 1;
        if (memo[l][r] != -1) return memo[l][r];
        int result = 0;
        for (int i = l; i <= r; i++) {
            int ll = dfs(l, i - 1, memo);
            int rr = dfs(i + 1, r, memo);
            result += ll * rr;
        }
        memo[l][r] = result;
        return result;
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: dp
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
