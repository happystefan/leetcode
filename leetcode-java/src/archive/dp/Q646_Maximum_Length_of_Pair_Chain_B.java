package archive.dp;

import java.util.*;

public class Q646_Maximum_Length_of_Pair_Chain_B {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int cur = Integer.MIN_VALUE, result = 0;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                result++;
            }
        }
        return result;
    }

}
