package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0054_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int u = 0, d = m - 1;
        int l = 0, r = n - 1;
        while (result.size() < m * n) {
            for (int i = l; i <= r && result.size() < m * n; i++) result.add(matrix[u][i]);
            u++;
            for (int i = u; i <= d && result.size() < m * n; i++) result.add(matrix[i][r]);
            r--;
            for (int i = r; i >= l && result.size() < m * n; i--) result.add(matrix[d][i]);
            d--;
            for (int i = d; i >= u && result.size() < m * n; i--) result.add(matrix[i][l]);
            l++;
        }
        return result;
    }

}
