package random_pick;

import java.util.*;

public class Q528_Random_Pick_with_Weight_C {

    class Solution {
        int[] sums;
        Random random = new Random();
        public Solution(int[] w) {
            sums = new int[w.length];
            for (int i = 0; i < sums.length; i++) {
                sums[i] += (i == 0 ? 0 : sums[i-1])+w[i];
            }
        }

        public int pickIndex() {
            int target = random.nextInt(sums[sums.length-1]);
            int l = 0, r = sums.length-1;
            while (l <= r) {
                int m = l+(r-l)/2;
                if (sums[m] <= target) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
            return l;
        }
    }

}
