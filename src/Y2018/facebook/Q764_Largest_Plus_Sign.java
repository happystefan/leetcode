package Y2018.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q764_Largest_Plus_Sign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(mine[0] * N + mine[1]);
        }
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                cnt = set.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = cnt;
            }
            cnt = 0;
            for (int j = N - 1; j >= 0; j--) {
                cnt = set.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt = set.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            cnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                cnt = set.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
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
