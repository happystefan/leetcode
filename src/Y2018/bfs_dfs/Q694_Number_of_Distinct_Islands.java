package Y2018.bfs_dfs;

import java.util.HashSet;
import java.util.Set;

public class Q694_Number_of_Distinct_Islands {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        grid[i][j] = 0;
        int m = grid.length, n = grid[0].length;
        for (int k = 0; k < dirs.length; k++) {
            int[] dir = dirs[k];
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] != 1) {
                sb.append("#");
                continue;
            }
            sb.append(k);
            dfs(grid, ii, jj, sb);
        }
    }

}
