package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q038_Search_a_2D_Matrix_II {

    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;
        int ans = 0;
        int i = 0, j = matrix[0].length;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
            else {
                ans++;
                j--;
            }
        }
        return ans;
    }

}
