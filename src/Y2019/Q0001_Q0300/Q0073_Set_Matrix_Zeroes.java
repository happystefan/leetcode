package Y2019.Q0001_Q0300;

public class Q0073_Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) row = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (col) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

}
