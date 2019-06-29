package google;

public class Q463_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int[] ans = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visit, i, j, ans);
                    break;
                }
            }
        }
        return ans[0];
    }

    public void dfs(int[][] grid, boolean[][] visit, int i, int j, int[] ans) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            ans[0]++;
            return;
        }
        if (visit[i][j]) return;
        visit[i][j] = true;

        dfs(grid, visit, i - 1, j, ans);
        dfs(grid, visit, i + 1, j, ans);
        dfs(grid, visit, i, j - 1, ans);
        dfs(grid, visit, i, j + 1, ans);
    }

}
