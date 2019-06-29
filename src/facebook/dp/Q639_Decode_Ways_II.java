package facebook.dp;

public class Q639_Decode_Ways_II {

    int M = (int) 1e9 + 7;

    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        long[] dp = new long[ss.length + 1];
        dp[0] = 1;
        dp[1] = ss[0] == '*' ? 9 : (ss[0] == '0' ? 0 : 1);
        for (int i = 1; i < ss.length; i++) {
            char curr = ss[i];
            char prev = ss[i - 1];
            if (curr == '*') {
                dp[i + 1] = 9 * dp[i];
                if (prev == '1') {
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                } else if (prev == '2') {
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                } else if (prev == '*') {
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
                }
            } else {
                dp[i + 1] = ss[i] == '0' ? 0 : dp[i];
                if (prev == '1') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (prev == '2' && curr <= '6') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (prev == '*') {
                    dp[i + 1] = (dp[i + 1] + (curr <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }
        }
        return (int) dp[ss.length];
    }

}
