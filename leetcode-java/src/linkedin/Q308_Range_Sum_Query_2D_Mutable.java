package linkedin;

public class Q308_Range_Sum_Query_2D_Mutable {

    class NumMatrix {

        int[][] nums;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            nums = new int[matrix.length][matrix[0].length];
            sums = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            if (nums == null || nums.length == 0 || nums[0].length == 0) {
                return;
            }
            int diff = val-nums[row][col];
            nums[row][col] = val;
            for (int i = row+1; i <= nums.length; i += i&(-i)) {
                for (int j = col+1; j <= nums[0].length; j += j&(-j)) {
                    sums[i][j] += diff;
                }
            }
        }

        private int sum(int row, int col) {
            int result = 0;
            for (int i = row+1; i > 0; i -= i&(-i)) {
                for (int j = col+1; j > 0; j -= j&(-j)) {
                    result += sums[i][j];
                }
            }
            return result;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (nums == null || nums.length == 0 || nums[0].length == 0) {
                return 0;
            }
            return sum(row2, col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

}
