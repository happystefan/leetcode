package google;

import java.util.*;

public class Q710_Random_Pick_with_Blacklist {
    // Memory Limit Exceeded
    class Solution {
        List<Integer> list;
        Random random;
        public Solution(int N, int[] blacklist) {
            list = new ArrayList<>(N);
            Set<Integer> set = new HashSet<>();
            for (int i : blacklist) {
                set.add(i);
            }
            for (int i = 0; i < N; i++) {
                if (set.contains(i)) {
                    continue;
                }
                list.add(i);
            }
            random = new Random();
        }

        public int pick() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */

}
