package archive.google;

public class Q498_Diagonal_Traverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            ans[i] = matrix[r][c];
            if ((r+c)%2 == 0) { // move up
                if (c == n-1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else { //move down
                if (r == m-1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return ans;
    }

}
