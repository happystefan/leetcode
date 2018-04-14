package facebook;

public class Q433_Number_of_Islands {

    public int numIslands(boolean[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                dfs(i, j, grid);
                result++;
            }
        }
        return result;
    }

    private void dfs(int i, int j, boolean[][] grid) {
        grid[i][j] = false;
        int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };
        for (int[] dir : dirs) {
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            if (next_i < 0 || next_i >= grid.length || next_j < 0 || next_j >= grid[0].length) {
                continue;
            }
            if (!grid[next_i][next_j]) {
                continue;
            }
            dfs(next_i, next_j, grid);
        }
    }

}