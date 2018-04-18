package facebook;

public class Q436_Maximal_Square {

    public int maxSquare(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        dp[0][0] = 0;
        int result = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i-1][j-1] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    result = Math.max(result, dp[i][j]*dp[i][j]);
                }
            }
        }
        return result;
    }
}
