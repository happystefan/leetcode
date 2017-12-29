package google;

import java.util.LinkedList;
import java.util.List;

public class Q054_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;
        int rb = 0, re = matrix.length-1;
        int cb = 0, ce = matrix[0].length-1;
        while (rb <= re || cb <= ce) {
            if (rb <= re) { // go right
                for (int i = cb; i <= ce; i++) ans.add(matrix[rb][i]);
                rb++;
            }
            if (cb <= ce) { // go down
                for (int i = rb; i <= re; i++) ans.add(matrix[i][ce]);
                ce--;
            }
            if (rb <= re) { // go left
                for (int i = ce; i >= cb; i--) ans.add(matrix[re][i]);
                re--;
            }
            if (cb <= ce) { // go up
                for (int i = re; i >= rb; i--) ans.add(matrix[i][cb]);
                cb++;
            }
        }
        return ans;
    }

}
