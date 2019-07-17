package Y2019.Q0001_Q0300;

public class Q0059_Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1;
        int num = 0;
        while (num <= n * n) {
            for (int i = l; i <= r && num <= n * n; i++) matrix[u][i] = num++;
            u++;
            for (int i = u; i <= d && num <= n * n; i++) matrix[i][r] = num++;
            r--;
            for (int i = r; i >= l && num <= n * n; i--) matrix[d][i] = num++;
            d--;
            for (int i = d; i >= u && num <= n * n; i--) matrix[i][l] = num++;
            l++;
        }
        return matrix;
    }

}
