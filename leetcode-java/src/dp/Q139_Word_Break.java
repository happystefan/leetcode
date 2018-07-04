package dp;

import java.util.*;

public class Q139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] |= dp[j];
                }
            }
        }
        return dp[s.length()];
    }

}
