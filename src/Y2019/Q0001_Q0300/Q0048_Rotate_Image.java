package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.Collections;

public class Q0048_Rotate_Image {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        int n = matrix.length;
        // Arrays.asList() Returns a fixed-size list backed by the specified array.
        // Changes to the returned list "write through" to the array.
        Collections.reverse(Arrays.asList(matrix));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
