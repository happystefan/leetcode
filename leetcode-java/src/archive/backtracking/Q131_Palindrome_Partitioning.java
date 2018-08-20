package archive.backtracking;

import java.util.*;

public class Q131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[ss.length][ss.length];
        for (int i = 0; i < ss.length; i++) {
            dp[i][i] = true;
            if (i+1 < ss.length && ss[i] == ss[i+1]) {
                dp[i][i+1] = true;
            }
        }
        for (int l = 2; l < ss.length; l++) {
            for (int i = 0; i+l < ss.length; i++) {
                int j = i+l;
                dp[i][j] = dp[i+1][j-1] && ss[i] == ss[j];
            }
        }
        List<List<String>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), dp, 0, s);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, boolean[][] dp, int pos, String s) {
        if (pos == s.length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (!dp[pos][i]) continue;
            list.add(s.substring(pos, i+1));
            dfs(result, list, dp, i+1, s);
            list.remove(list.size()-1);
        }
    }

}
