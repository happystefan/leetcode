package Y2019.Q0001_Q0300;

public class Q0074_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int ii = mid / n, jj = mid % n;
            if (matrix[ii][jj] < target) l = mid + 1;
            else r = mid;
        }
        return matrix[l / n][l % n] == target;
    }

}
