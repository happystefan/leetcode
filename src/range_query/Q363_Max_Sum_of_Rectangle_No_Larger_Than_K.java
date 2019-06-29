package range_query;

public class Q363_Max_Sum_of_Rectangle_No_Larger_Than_K {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int h = 0; i + h <= m; h++) {
                    for (int w = 0; j + w <= n; w++) {
                        int area = dp[i + h][j + w] - dp[i - 1][j + w] - dp[i + h][j - 1] + dp[i - 1][j - 1];
                        if (area <= k && area > result) {
                            result = area;
                        }
                    }
                }
            }
        }
        return result;
    }

}
