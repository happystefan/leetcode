package dp;

import java.util.*;

public class Q064_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int ii = i+dir[0], jj = j+dir[1];
                    if (ii >= m || jj >= n) {
                        continue;
                    }
                    dp[ii][jj] = Math.min(dp[ii][jj], dp[i][j]+grid[ii][jj]);
                }
            }
        }
        return dp[m-1][n-1];
    }

}
