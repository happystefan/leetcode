package Y2018.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q140_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] |= dp[j];
                }
            }
        }
        List<String> result = new LinkedList<>();
        if (!dp[s.length()]) {
            return result;
        }
        dfs(result, s.length(), "", s, dp, set);
        return result;
    }

    private void dfs(List<String> result, int pos, String str, String s, boolean[] dp, Set<String> set) {
        if (pos < 0) {
            return;
        }
        if (pos == 0) {
            result.add(str.trim());
            return;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (!dp[i] || !set.contains(s.substring(i, pos))) {
                continue;
            }
            String new_str = s.substring(i, pos) + " " + str;
            dfs(result, i, new_str, s, dp, set);
        }
    }

}
