package facebook.increasing_subsequence;

import java.util.Arrays;

public class Q646_Maximum_Length_of_Pair_Chain {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int curr = Integer.MIN_VALUE;
        int result = 0;
        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                curr = pair[1];
                result++;
            }
        }
        return result;
    }

}
