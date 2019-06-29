package range_query;

public class Q727_Minimum_Window_Subsequence_B {

    Integer[][] memo;

    public String minWindow(String S, String T) {
        memo = new Integer[S.length() + 1][T.length() + 1];
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                int j = dfs(S, T, i, 0);
                if (j != -1 && j - i < min) {
                    min = j - i;
                    result = S.substring(i, j);
                }
            }
        }
        return result;
    }

    private int dfs(String S, String T, int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int result = -1;
        if (j == T.length()) {
            result = i;
        } else if (i == S.length()) {
            result = -1;
        } else if (S.charAt(i) == T.charAt(j)) {
            result = dfs(S, T, i + 1, j + 1);
        } else {
            result = dfs(S, T, i + 1, j);
        }
        memo[i][j] = result;
        return result;
    }

}
