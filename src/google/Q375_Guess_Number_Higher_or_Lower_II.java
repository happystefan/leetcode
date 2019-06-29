package google;

public class Q375_Guess_Number_Higher_or_Lower_II {

    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        return dp(f, 1, n);
    }

    private int dp(int[][] f, int s, int e) {
        if (s >= e) return 0;
        if (f[s][e] != 0) return f[s][e];
        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            min = Math.min(min, i + Math.max(dp(f, s, i - 1), dp(f, i + 1, e)));
        }
        f[s][e] = min;
        return min;
    }

}
