package archive.dp;

import java.util.*;

public class Q646_Maximum_Length_of_Pair_Chain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (pairs[j][0] > pairs[i][1]) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                    result = Math.max(result, dp[j]);
                }
            }
        }
        return result;
    }

}
