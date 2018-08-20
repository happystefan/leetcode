package archive.facebook;

public class Q311_Sparse_Matrix_Multiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length, colA = A[0].length;
        int rowB = B.length, colB = B[0].length;
        int[][] result = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int k = 0; k < colA; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < colB; j++) {
                    // if (B[k][j] == 0) continue;
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

}
