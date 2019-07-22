package Y2019.Q0001_Q0300;

public class Q0085_Maximal_Rectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1] - '0';
            }
        }
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int h = 0; i + h <= m; h++) {
                    for (int w = 0; j + w <= n; w++) {
                        int cnt = dp[i + h][j + w] - dp[i - 1][j + w] - dp[i + h][j - 1] + dp[i - 1][j - 1];
                        if (cnt == (w + 1) * (h + 1)) {
                            result = Math.max(result, cnt);
                        }
                    }
                }
            }
        }
        return result;
    }

}
