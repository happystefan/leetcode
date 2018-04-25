package facebook;

public class Q654_Sparse_Matrix_Multiplication_C {

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < B[0].length; j++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

}
