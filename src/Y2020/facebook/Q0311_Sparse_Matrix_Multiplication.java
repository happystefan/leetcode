package Y2020.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q0311_Sparse_Matrix_Multiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length, colA = A[0].length;
        int rowB = B.length, colB = B[0].length;
        Set<Integer>[] AA = new Set[rowA];
        Set<Integer>[] BB = new Set[colB];
        for (int i = 0; i < rowA; i++) {
            AA[i] = new HashSet<>();
            for (int j = 0; j < colA; j++) {
                if (A[i][j] == 0) continue;
                AA[i].add(j);
            }
        }
        for (int j = 0; j < colB; j++) {
            BB[j] = new HashSet<>();
            for (int i = 0; i < rowB; i++) {
                if (B[i][j] == 0) continue;
                AA[j].add(i);
            }
        }
        int[][] C = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            Set<Integer> seta = AA[i];
            Set<Integer> setb = BB[i];
            for (int j : seta) {
                if (!setb.contains(j)) continue;
                C[i][j] += A[i][j] * B[i][j];
            }
        }
        return C;
    }

}
