package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q001_Best_Attack_Strategy {

    public List<int[]> bestAttack(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return null;
        }
        int m = matrix.length, n = matrix[0].length;
        List<int[]> rslt = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                int[] cnt = new int[]{0};
                dfs(matrix, i, j, cnt);
                rslt.add(new int[]{i, j, cnt[0]});
            }
        }

        return rslt;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(int[][] matrix, int i, int j, int[] cnt) {
        int m = matrix.length, n = matrix[0].length;

        cnt[0]++;
        matrix[i][j] *= -1;

        for (int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >=n) {
                continue;
            }
            if (matrix[ii][ii] != 1) continue;
            dfs(matrix, ii, jj, cnt);
        }
    }
}
