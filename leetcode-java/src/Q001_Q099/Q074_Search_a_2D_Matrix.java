package Q001_Q099;

public class Q074_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = row*col-1;
        while (i <= j) {
            int m = (i+j)/2;
            if (matrix[m/col][m%col] > target) j = m-1;
            else if (matrix[m/col][m%col] < target) i = m+1;
            else return true;
        }
        return false;
    }

}
