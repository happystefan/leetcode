package facebook;

public class Q463_Island_Perimeter {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] result = new int[]{0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(result, i, j, grid, new boolean[m][n]);
                    return result[0];
                }
            }
        }
        return result[0];
    }

    private void dfs(int[] result, int i, int j, int[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] == 0) {
                result[0] += 1;
                continue;
            }
            if (visited[ii][jj]) {
                continue;
            }
            dfs(result, ii, jj, grid, visited);
        }
    }

}
