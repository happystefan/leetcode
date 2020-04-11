package Y2020.facebook;

public class Q0718_Maximum_Length_of_Repeated_Subarray {

    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int rslt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                rslt = Math.max(rslt, dp[i + 1][j + 1]);
            }
        }
        return rslt;
    }

}
