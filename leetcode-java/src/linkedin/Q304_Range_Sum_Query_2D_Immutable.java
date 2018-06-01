package linkedin;

public class Q304_Range_Sum_Query_2D_Immutable {

    class NumMatrix {

        int sums[][];
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            sums = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                int tmp = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    tmp += matrix[i][j];
                    sums[i+1][j+1] = sums[i][j+1] + tmp;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sums.length == 0) {
                return 0;
            }
            return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

}
