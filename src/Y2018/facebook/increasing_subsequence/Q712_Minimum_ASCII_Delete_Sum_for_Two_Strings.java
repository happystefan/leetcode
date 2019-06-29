package Y2018.facebook.increasing_subsequence;

public class Q712_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    public int minimumDeleteSum(String s1, String s2) {
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();
        int[][] dp = new int[ss1.length + 1][ss2.length + 1];
        for (int i = 1; i <= ss1.length; i++) {
            for (int j = 1; j <= ss2.length; j++) {
                if (ss1[i - 1] == ss2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + ss1[i - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.chars().sum() + s2.chars().sum() - 2 * dp[ss1.length][ss2.length];
    }

}
