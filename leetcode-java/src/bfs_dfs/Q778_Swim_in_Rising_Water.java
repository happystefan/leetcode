package bfs_dfs;

public class Q778_Swim_in_Rising_Water {

    public int swimInWater(int[][] grid) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                l = Math.min(l, grid[i][j]);
                r = Math.max(r, grid[i][j]);
            }
        }
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid < grid[0][0] || !swim(grid, 0, 0, mid, new boolean[m][n])) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean swim(int[][] grid, int i, int j, int d, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i == m-1 && j == n-1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] > d || visited[ii][jj]) {
                continue;
            }
            if (swim(grid, ii, jj, d, visited)) {
                return true;
            }
        }
        return false;
    }

}

