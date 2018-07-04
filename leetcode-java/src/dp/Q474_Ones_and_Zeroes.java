package dp;

public class Q474_Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] cnt = count(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i-cnt[0]][j-cnt[1]]+1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int one = 0, zero = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return new int[]{zero, one};
    }

}
