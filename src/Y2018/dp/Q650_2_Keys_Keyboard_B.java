package Y2018.dp;

public class Q650_2_Keys_Keyboard_B {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                    break;
                }
            }
        }
        return dp[n];
    }

}
