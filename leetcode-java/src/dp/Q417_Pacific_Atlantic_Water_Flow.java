package dp;

import java.util.*;

public class Q417_Pacific_Atlantic_Water_Flow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new LinkedList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pac, i, 0);
            dfs(matrix, atl, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pac, 0, j);
            dfs(matrix, atl, m-1, j);
        }
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i+dir[0], jj = j+dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || visited[ii][jj] || matrix[ii][jj] < matrix[i][j]) {
                continue;
            }
            dfs(matrix, visited, ii, jj);
        }
    }

}
