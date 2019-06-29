package Y2018.dp;

public class Q741_Cherry_Pickup {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // DFS: Time Limit Exceeded
    public int cherryPickup(int[][] grid) {
        int[] result = new int[]{0};
        int m = grid.length, n = grid[0].length;
        dfs(result, grid, 0, 0, 0, true, new int[m][n]);
        return result[0];
    }

    private void dfs(int[] result, int[][] grid, int i, int j, int sum, boolean firstCall, int[][] visited) {
        int m = grid.length, n = grid[0].length;
        sum += visited[i][j] == 0 ? grid[i][j] : 0;
        int v = visited[i][j];
        visited[i][j] = firstCall ? 1 : 2;
        if (!firstCall && i == 0 && j == 0) {
            result[0] = Math.max(result[0], sum);
            return;
        }
        if (i == m - 1 && j == n - 1 && firstCall) {
            dfs(result, grid, i, j, sum, false, visited);
            return;
        }
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n ||
                    grid[ii][jj] == -1 ||
                    (firstCall && visited[ii][jj] == 1) ||
                    (!firstCall && visited[ii][jj] == 2)) {
                continue;
            }
            dfs(result, grid, ii, jj, sum, firstCall, visited);
        }
        visited[i][j] = v;
    }

}
