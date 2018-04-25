package facebook;

import java.util.ArrayList;
import java.util.List;

public class Q654_Sparse_Matrix_Multiplication {

    public int[][] multiply(int[][] A, int[][] B) {

        int[][] result = new int[A.length][B[0].length];

        List<List<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            cols.add(new ArrayList<>());
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] == 0) {
                    continue;
                }
                cols.get(i).add(j);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int p = 0; p < cols.get(k).size(); p++) {
                    int j = cols.get(k).get(p);
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

}
