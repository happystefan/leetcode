package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q433_Number_of_Islands {

    public int numIslands(boolean[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, boolean[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || !grid[i][j]) return;
        grid[i][j] = false;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }

}
