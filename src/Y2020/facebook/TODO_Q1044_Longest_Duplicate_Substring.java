package Y2020.facebook;

public class TODO_Q1044_Longest_Duplicate_Substring {

    // Memory Limit Exceeded
    class solution_dp {

        public String longestDupSubstring(String S) {
            char[] ss = S.toCharArray();
            int n = ss.length;
            int[][] dp = new int[n + 1][n + 1];
            String rslt = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (ss[i] == ss[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > rslt.length()) rslt = S.substring(i - dp[i + 1][j + 1] + 1, i + 1);
                }
            }
            return rslt;
        }

    }

    class solution_KMP_TODO {

    }

}
