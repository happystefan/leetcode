package dp;

public class Q413_Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n][n];
        int[][] diff = new int[n][n];
        boolean[][] valid = new boolean[n][n];
        for (int i = 0; i+1 < n; i++) {
            diff[i][i+1] = A[i+1]-A[i];
            valid[i][i+1] = true;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i]-A[i-1] == diff[j][i-1] && valid[j][i-1]) {
                    diff[j][i] = diff[j][i-1];
                    dp[j][i] = true;
                    valid[j][i] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

}
