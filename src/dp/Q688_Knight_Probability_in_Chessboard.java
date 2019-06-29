package dp;

public class Q688_Knight_Probability_in_Chessboard {

    int[][] dirs = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    Double[][][] dp;

    public double knightProbability(int N, int K, int r, int c) {
        dp = new Double[N][N][K + 1];
        return dfs(N, K, r, c);
    }

    private double dfs(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (dp[r][c][K] != null) {
            return dp[r][c][K];
        }
        double result = 0;
        for (int[] dir : dirs) {
            int i = r + dir[0], j = c + dir[1];
            result += 0.125 * dfs(N, K - 1, i, j);
        }
        dp[r][c][K] = result;
        return result;
    }

}
