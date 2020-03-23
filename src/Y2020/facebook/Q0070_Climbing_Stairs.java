package Y2020.facebook;

public class Q0070_Climbing_Stairs {

    class solution_dp {

        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

    }

    class solution_fibonacci {

        public int climbStairs(int n) {
            if (n == 1) return 1;
            int i = 1;
            int j = 2;
            for (int k = 2; k <= n; k++) {
                int nxt = i + j;
                i = j;
                j = nxt;
            }
            return j;
        }

    }

}
