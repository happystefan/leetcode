package archive.dp;

public class Q471_Encode_String_with_Shortest_Length {

    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i+l < n; i++) {
                int j = i+l;
                String sub = s.substring(i, j+1);
                if (j-i < 4) {
                    dp[i][j] = sub;
                    continue;
                }
                dp[i][j] = sub;
                for (int k = i; k < j; k++) {
                    if (dp[i][k].length()+dp[k+1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k]+dp[k+1][j];
                    }
                }
                for (int k = 0; k < sub.length(); k++) {
                    String pattern = sub.substring(0, k+1);
                    if (pattern != null && sub.length() % pattern.length() == 0 && sub.replaceAll(pattern, "").equals("")) {
                        String ss = sub.length()/pattern.length() + "[" + dp[i][i+k] + "]";
                        if (ss.length() < dp[i][j].length()) {
                            dp[i][j] = ss;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }

}
