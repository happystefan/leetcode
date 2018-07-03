package Q001_Q300;

public class Q200_Number_of_Islands {

    boolean[][] visit;
    int ans = 0;

    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (visit[i][j] || grid[i][j] == '0') return;
        visit[i][j] = true;
        bfs(grid, i-1, j);
        bfs(grid, i+1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);
    }

}
