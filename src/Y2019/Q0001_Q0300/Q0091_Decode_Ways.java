package Y2019.Q0001_Q0300;

public class Q0091_Decode_Ways {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i > 1) {
                int val = Integer.valueOf(s.substring(i - 2, i));
                if (val >= 10 && val <= 26) dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
