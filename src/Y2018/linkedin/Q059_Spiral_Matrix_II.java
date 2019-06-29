package Y2018.linkedin;

public class Q059_Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0, r = n - 1;
        int u = 0, d = n - 1;
        int dir = 0;
        for (int c = 1; c <= n * n; ) {
            if (dir == 0) {
                // go right
                for (int j = l; j <= r; j++) {
                    result[u][j] = c++;
                }
                u += 1;
                dir = 1;
            } else if (dir == 1) {
                // go down
                for (int i = u; i <= d; i++) {
                    result[i][r] = c++;
                }
                r -= 1;
                dir = 2;
            } else if (dir == 2) {
                // go left
                for (int j = r; j >= l; j--) {
                    result[d][j] = c++;
                }
                d -= 1;
                dir = 3;
            } else if (dir == 3) {
                // go up
                for (int i = d; i >= u; i--) {
                    result[i][l] = c++;
                }
                l += 1;
                dir = 0;
            }
        }
        return result;
    }

}
