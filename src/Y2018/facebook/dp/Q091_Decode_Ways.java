package Y2018.facebook.dp;

public class Q091_Decode_Ways {

    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length + 1];
        dp[0] = 1;
        dp[1] = ss[0] == '0' ? 0 : 1;
        for (int i = 1; i < ss.length; i++) {
            char prev = ss[i - 1];
            char curr = ss[i];
            if (curr != '0') dp[i + 1] += dp[i];
            if (prev == '1' || (prev == '2' && curr <= '6')) dp[i + 1] += dp[i - 1];
        }
        return dp[ss.length];
    }

}
