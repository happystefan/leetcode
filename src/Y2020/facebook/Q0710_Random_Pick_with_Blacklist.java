package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q0710_Random_Pick_with_Blacklist {

    class Solution {

        Map<Integer, Integer> map = new HashMap<>();
        Random r = new Random();
        int m;

        public Solution(int N, int[] blacklist) {
            for (int b : blacklist) map.put(b, -1);
            m = N - map.size();
            for (int b : blacklist) {
                if (b < m) {
                    while (map.containsKey(N - 1)) N--;
                    map.put(b, N - 1);
                    N--;
                }
            }
        }

        public int pick() {
            int i = r.nextInt(m);
            return map.getOrDefault(i, i);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */

}
