package facebook;

import java.util.Set;

public class Q107_Word_Break {

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        int maxLen = 0;
        for (String word : dict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= i+maxLen && j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (dict.contains(str) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
