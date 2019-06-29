package facebook;

public class Q498_Diagonal_Traverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int i = 0, j = 0, k = 0;
        while (k < m * n) {
            result[k++] = matrix[i][j];
            if ((i + j) % 2 == 0) { // go up
                if (j == n - 1) i++;
                else if (i == 0) j++;
                else {
                    i--;
                    j++;
                }
            } else { // go down
                if (i == m - 1) j++;
                else if (j == 0) i++;
                else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

}
