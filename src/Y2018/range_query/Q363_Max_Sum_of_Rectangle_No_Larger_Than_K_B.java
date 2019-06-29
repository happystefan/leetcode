package Y2018.range_query;

import java.util.TreeSet;

public class Q363_Max_Sum_of_Rectangle_No_Larger_Than_K_B {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i][j - 1] + matrix[i - 1][j - 1];
            }
        int result = Integer.MIN_VALUE;
        for (int j = 0; j <= n; j++) {
            for (int jj = j + 1; jj <= n; jj++) {
                TreeSet<Integer> set = new TreeSet<>();
                int sum = 0;
                for (int i = 0; i < m + 1; i++) {
                    sum += dp[i][jj] - dp[i][j];
                    Integer ceiling = set.ceiling(sum - k);
                    if (ceiling != null) {
                        result = Math.max(result, sum - ceiling);
                    }
                    set.add(sum);
                }
            }
        }
        return result;
    }

}

