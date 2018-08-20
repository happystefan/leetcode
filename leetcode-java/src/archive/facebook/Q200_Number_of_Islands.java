package archive.facebook;

public class Q200_Number_of_Islands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i+dir[0], jj = j+dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] == '0' || visited[ii][jj]) {
                continue;
            }
            dfs(grid, ii, jj, visited);
        }
        return;
    }

}
