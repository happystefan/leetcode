package Y2019.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0007_Longest_Path_in_DAG {
    /*
    329. Longest Increasing Path in a Matrix
    */

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs with memo
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    int[][] memo;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath_DFS(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        int m = matrix.length, n = matrix[0].length;
        int result = 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
            if (matrix[ii][jj] <= matrix[i][j]) continue;
            result = Math.max(result, 1 + dfs(matrix, ii, jj));
        }
        memo[i][j] = result;
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: topological sort
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int longestIncreasingPath_TopSort(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        List<int[]>[][] neighbors = new LinkedList[m][n];
        int[][] degrees = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
                    if (matrix[ii][jj] <= matrix[i][j]) continue;
                    if (neighbors[i][j] == null) neighbors[i][j] = new LinkedList<int[]>();
                    neighbors[i][j].add(new int[]{ii, jj});
                    degrees[ii][jj] += 1;
                }
            }
        }

        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (degrees[i][j] == 0) Q.add(new int[]{i, j});
            }
        }

        int result = 0;
        while (!Q.isEmpty()) {
            result++;
            int size = Q.size();
            while (size-- > 0) {
                int[] pair = Q.poll();
                int i = pair[0], j = pair[1];
                if (neighbors[i][j] == null) continue;
                for (int[] neighbor : neighbors[i][j]) {
                    int ii = neighbor[0], jj = neighbor[1];
                    degrees[ii][jj]--;
                    if (degrees[ii][jj] == 0) Q.add(neighbor);
                }
            }
        }

        return result;
    }

}
