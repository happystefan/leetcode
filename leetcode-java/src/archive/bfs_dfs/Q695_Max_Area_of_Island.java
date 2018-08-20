package archive.bfs_dfs;

public class Q695_Max_Area_of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        int result = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int ii = i+dir[0], jj = j+dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] == 0) {
                continue;
            }
            result += dfs(grid, ii, jj);
        }
        return result;
    }

}
