package facebook.dp;

import java.util.Arrays;

public class Q764_Largest_Plus_Sign {

    // Time Limit Exceeded
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(board[i], 1);
        for (int[] xy : mines) board[xy[0]][xy[1]] = 0;

        int result = 0;
        boolean[][][] dp = new boolean[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                dp[i][j][0] = true;
                result = 1;
            }
        }
        for (int l = 1; l < N; l++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i - l < 0 || i + l >= N || j - l < 0 || j + l >= N) continue;
                    dp[i][j][l] = dp[i][j][l - 1] &&
                            board[i - l][j] == 1 &&
                            board[i + l][j] == 1 &&
                            board[i][j - l] == 1 &&
                            board[i][j + l] == 1;
                    if (dp[i][j][l]) result = Math.max(result, l + 1);
                }
            }
        }
        return result;
    }

}
