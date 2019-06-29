package facebook;

public class Q835_Image_Overlap_B {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int[][][][] dp = new int[n + 1][n + 1][n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {
                        dp[i][j][k][l] =
                                (A[i - 1][j - 1] & B[k - 1][l - 1])
                                        + dp[i - 1][j][k - 1][l]
                                        + dp[i][j - 1][k][l - 1]
                                        - dp[i - 1][j - 1][k - 1][l - 1];
                        max = Math.max(max, dp[i][j][k][l]);
                    }
                }
            }
        }
        return max;
    }

}
