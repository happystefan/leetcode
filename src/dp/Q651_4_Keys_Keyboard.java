package dp;

public class Q651_4_Keys_Keyboard {

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }

}
