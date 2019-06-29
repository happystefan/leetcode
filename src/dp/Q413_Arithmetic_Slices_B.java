package dp;

public class Q413_Arithmetic_Slices_B {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] += dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }

}
