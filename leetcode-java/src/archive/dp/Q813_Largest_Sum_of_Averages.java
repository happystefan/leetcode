package archive.dp;

public class Q813_Largest_Sum_of_Averages {

    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] sum = new double[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i]+A[i];
        }
        double[][] dp = new double[n+1][K+1];
        for (int i = 1; i <= n; i++) {
            dp[i-1][1] = (sum[i]-sum[0])/i;
        }
        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1]+(sum[i+1]-sum[j+1])/(i-j));
                }
            }
        }
        return dp[n-1][K];
    }

}
