package archive.random_pick;

import java.util.*;

public class Q528_Random_Pick_with_Weight {

    class Solution {

        int sum;
        int[] w;
        Random random = new Random();
        public Solution(int[] w) {
            sum = Arrays.stream(w).sum();
            this.w = w;
        }

        public int pickIndex() {
            int rand = random.nextInt(sum);
            int cnt = 0;
            for (int i = 0; i < w.length; i++) {
                cnt += w[i];
                if (cnt > rand) {
                    return i;
                }
            }
            return -1;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

}
