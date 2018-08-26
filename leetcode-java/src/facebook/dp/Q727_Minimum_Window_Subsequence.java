package facebook.dp;

public class Q727_Minimum_Window_Subsequence {

    Integer[][] memo;
    public String minWindow(String S, String T) {
        char[] ss = S.toCharArray(), tt = T.toCharArray();
        memo = new Integer[ss.length+1][tt.length+1];
        String result = "";
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == tt[0]) {
                int j = dfs(ss, tt, i, 0);
                if (j == -1) continue;
                if (result.equals("") || j-i < result.length()) {
                    result = S.substring(i, j);
                }
            }
        }
        return result;
    }

    private int dfs(char[] ss, char[] tt, int i, int j) {
        if (memo[i][j] != null) return memo[i][j];
        int result = -1;
        if (j == tt.length) result = i;
        else if (i == ss.length) result = -1;
        else if (ss[i] == tt[j]) result = dfs(ss, tt, i+1, j+1);
        else result = dfs(ss, tt, i+1, j);
        memo[i][j] = result;
        return result;
    }

}
