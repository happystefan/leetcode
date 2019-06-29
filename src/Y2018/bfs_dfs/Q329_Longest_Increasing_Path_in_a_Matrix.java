package Y2018.bfs_dfs;

public class Q329_Longest_Increasing_Path_in_a_Matrix {

    int[][] memo;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j);
                result = Math.max(result, len);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || matrix[ii][jj] <= matrix[i][j]) {
                continue;
            }
            result = Math.max(result, 1 + dfs(matrix, ii, jj));
        }
        memo[i][j] = result;
        return result;
    }

}
