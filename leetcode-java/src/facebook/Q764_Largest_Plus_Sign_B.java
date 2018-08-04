package facebook;

import java.util.*;

public class Q764_Largest_Plus_Sign_B {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], N);
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0, l = 0; j < N; j++) {
                l = dp[i][j] == 0 ? 0 : l+1;
                dp[i][j] = Math.min(dp[i][j], l);
            }
            for (int j = N-1, r = 0; j >= 0; j--) {
                r = dp[i][j] == 0 ? 0 : r+1;
                dp[i][j] = Math.min(dp[i][j], r);
            }
        }
        for (int j = 0; j < N; j++) {
            for (int i = 0, u = 0; i < N; i++) {
                u = dp[i][j] == 0 ? 0 : u+1;
                dp[i][j] = Math.min(dp[i][j], u);
            }
            for (int i = N-1, d = 0; i >= 0; i--) {
                d = dp[i][j] == 0 ? 0 : d+1;
                dp[i][j] = Math.min(dp[i][j], d);
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

}
