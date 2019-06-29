package Y2018.dp;

import java.util.Arrays;

public class Q576_Out_of_Boundary_Paths_B {

    int[][][] memo;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int M = 1000000000 + 7;
    int result = 0;

    public int findPaths(int m, int n, int N, int x, int y) {
        memo = new int[m][n][N + 1];
        for (int i = 0; i < m; i++) {
            for (int[] row : memo[i]) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(m, n, N, x, y);
    }

    private int dfs(int m, int n, int N, int x, int y) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[x][y][N] >= 0) {
            return memo[x][y][N];
        }
        int tmp = 0;
        for (int[] dir : dirs) {
            int i = x + dir[0], j = y + dir[1];
            tmp += dfs(m, n, N - 1, i, j);
            tmp %= M;
        }
        memo[x][y][N] = tmp;
        return memo[x][y][N];
    }

}
