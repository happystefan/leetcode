package dp;

public class Q091_Decode_Ways {

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 1; i < len; i++) {
            char pCh = s.charAt(i - 1);
            char cCh = s.charAt(i);
            if (cCh != '0') dp[i + 1] += dp[i];
            if (pCh == '1' || (pCh == '2' && cCh <= '6')) dp[i + 1] += dp[i - 1];
        }

        return dp[len];
    }

}
