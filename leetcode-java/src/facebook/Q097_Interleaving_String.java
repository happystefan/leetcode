package facebook;

public class Q097_Interleaving_String {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1+len2 != len3) {
            return false;
        }
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray(), ss3 = s3.toCharArray();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i < len1+1; i++) {
            dp[i][0] = dp[i-1][0] && ss3[i-1] == ss1[i-1];
        }
        for (int j = 1; j < len2+1; j++) {
            dp[0][j] = dp[0][j-1] && ss3[j-1] == ss2[j-1];
        }

        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                dp[i][j] = dp[i-1][j] && ss1[i-1] == ss3[i+j-1] ||
                        dp[i][j-1] && ss2[j-1] == ss3[i+j-1];
            }
        }
        return dp[len1][len2];
    }

}
