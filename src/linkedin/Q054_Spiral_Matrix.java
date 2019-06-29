package linkedin;

import java.util.LinkedList;
import java.util.List;

public class Q054_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;

        int dir = 0;
        while (result.size() < matrix.length * matrix[0].length) {
            if (dir == 0) {
                // go right;
                for (int j = l; j <= r; j++) {
                    result.add(matrix[u][j]);
                }
                u += 1;
                dir = 1; // go down in next round
            } else if (dir == 1) {
                // go down
                for (int i = u; i <= d; i++) {
                    result.add(matrix[i][r]);
                }
                r -= 1;
                dir = 2; // go left in next round
            } else if (dir == 2) {
                // go left
                for (int j = r; j >= l; j--) {
                    result.add(matrix[d][j]);
                }
                d -= 1;
                dir = 3; // go up in next round
            } else {
                // go up
                for (int i = d; i >= u; i--) {
                    result.add(matrix[i][l]);
                }
                l += 1;
                dir = 0; // go right in next step
            }
        }

        return result;
    }

}
