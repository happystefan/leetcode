package dp;

import java.util.*;

public class Q131_Palindrome_Partitioning {

    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i+1 < n && ss[i] == ss[i+1]) {
                dp[i][i+1] = true;
            }
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i+l < n; i++) {
                int j = i+l;
                dp[i][j] = dp[i+1][j-1] && ss[i] == ss[j];
            }
        }
        List<List<String>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, String s, int pos) {
        if (pos == s.length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                list.add(s.substring(pos, i+1));
                dfs(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }

}
