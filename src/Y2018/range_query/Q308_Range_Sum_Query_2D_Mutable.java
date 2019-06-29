package Y2018.range_query;

public class Q308_Range_Sum_Query_2D_Mutable {

    class NumMatrix {

        int[][] nums;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            nums = new int[matrix.length][matrix[0].length];
            sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int diff = val - nums[row][col];
            nums[row][col] = val;
            int i = row + 1;
            while (i <= nums.length) {
                int j = col + 1;
                while (j <= nums[0].length) {
                    sums[i][j] += diff;
                    j += j & -j;
                }
                i += i & -i;
            }
            // for (int i = row+1; i <= nums.length; i += i&(-i)) {
            //     for (int j = col+1; j <= nums[0].length; j += j&(-j)) {
            //         sums[i][j] += diff;
            //     }
            // }
        }

        private int query(int row, int col) {
            int result = 0;
            int i = row + 1;
            while (i > 0) {
                int j = col + 1;
                while (j > 0) {
                    result += sums[i][j];
                    j -= j & -j;
                }
                i -= i & -i;
            }

            // for (int i = row+1; i > 0; i -= i&(-i)) {
            //     for (int j = col+1; j > 0; j -= j&(-j)) {
            //         result += sums[i][j];
            //     }
            // }
            return result;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return query(row2, col2) - query(row2, col1 - 1) - query(row1 - 1, col2) + query(row1 - 1, col1 - 1);
        }
    }


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

}
