package facebook;

public class Q647_Palindromic_Substrings {

    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
            }
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + l; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j] == 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

}
