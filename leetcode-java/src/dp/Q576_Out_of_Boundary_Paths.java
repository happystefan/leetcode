package dp;

public class Q576_Out_of_Boundary_Paths {

    public int findPaths(int m, int n, int N, int x, int y) {
        int M = 1000000000 + 7;
        int dp[][] = new int[m][n];
        dp[x][y] = 1;
        int result = 0;
        for (int k = 0; k < N; k++) {
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1)
                        result = (result + dp[i][j]) % M;
                    if (j == n - 1)
                        result = (result + dp[i][j]) % M;
                    if (i == 0)
                        result = (result + dp[i][j]) % M;
                    if (j == 0)
                        result = (result + dp[i][j]) % M;

                    tmp[i][j] += i > 0 ? dp[i-1][j] : 0;
                    tmp[i][j] %= M;
                    tmp[i][j] += i < m-1 ? dp[i+1][j] : 0;
                    tmp[i][j] %= M;
                    tmp[i][j] += j > 0 ? dp[i][j-1] : 0;
                    tmp[i][j] %= M;
                    tmp[i][j] += j < n-1 ? dp[i][j+1] : 0;
                    tmp[i][j] %= M;
                }
            }
            dp = tmp;
        }
        return result;
    }

}
