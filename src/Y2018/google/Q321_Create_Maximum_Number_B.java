package Y2018.google;

import java.util.Arrays;

public class Q321_Create_Maximum_Number_B {

    // Time Limit Exceeded: O(m*n*k)
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int kk = 1; kk <= k; kk++) {
            String[][] nxt = new String[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                Arrays.fill(nxt[i], "");
            }
            for (int i = kk; i <= m; i++) {
                nxt[i][0] = max(dp[i - 1][0] + nums1[i - 1], nxt[i - 1][0]);
            }
            for (int j = kk; j <= n; j++) {
                nxt[0][j] = max(dp[0][j - 1] + nums2[j - 1], nxt[0][j - 1]);
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i + j < kk) continue;
                    nxt[i][j] = max(max(nxt[i - 1][j], nxt[i][j - 1]),
                            max(dp[i - 1][j] + nums1[i - 1], dp[i][j - 1] + nums2[j - 1]));
                }
            }
            dp = nxt;
        }
        int[] result = new int[k];
        for (int kk = 0; kk < k; kk++) {
            result[kk] = dp[m][n].charAt(kk) - '0';
        }
        return result;
    }

    private String max(String a, String b) {
        return a.compareTo(b) > 0 ? a : b;
    }

}

