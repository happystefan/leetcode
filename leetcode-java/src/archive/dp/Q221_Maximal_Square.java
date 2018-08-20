package archive.dp;

public class Q221_Maximal_Square {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max_len = 0;
        for (int i = 1; i < matrix.length+1; i++) {
            for (int j = 1; j < matrix[0].length+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        return max_len*max_len;
    }
}

