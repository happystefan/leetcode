package Y2020.linkedin.algo_part1;

public class Q039_Ponds_and_Islands {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class solution_num_land {

        public int countLand(int[][] matrix) {
            if (matrix == null || matrix.length == 0 ||
                    matrix[0] == null || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int rslt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 1) continue;
                    dfs(matrix, i, j);
                    rslt++;
                }
            }

            // recover matrix
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = 1;
                    }
                }
            }

            return rslt;
        }

        private void dfs(int[][] matrix, int i, int j) {
            int m = matrix.length, n = matrix[0].length;
            matrix[i][j] = -1;
            for (int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
                if (matrix[ii][jj] != 1) continue;
                dfs(matrix, ii, jj);
            }
        }
    }

    class solution_num_land_with_city {

        public int countLand(int[][] matrix) {
            if (matrix == null || matrix.length == 0 ||
                    matrix[0] == null || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int rslt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 1) continue;
                    boolean hasCity = dfs(matrix, i, j);
                    if (hasCity)rslt++;
                }
            }

            // recover matrix
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] *= -1;
                }
            }

            return rslt;
        }

        private boolean dfs(int[][] matrix, int i, int j) {
            int m = matrix.length, n = matrix[0].length;
            boolean hasCity = false;
            if (matrix[i][j] == 2) hasCity = true;
            matrix[i][j] *= -1;
            for (int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
                if (matrix[ii][jj] <= 0) continue;
                hasCity |= dfs(matrix, ii, jj);
            }
            return hasCity;
        }
    }

}
