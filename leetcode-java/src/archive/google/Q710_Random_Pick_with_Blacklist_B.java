package archive.google;

import java.util.*;

public class Q710_Random_Pick_with_Blacklist_B {

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        int len = 0;
        public Solution(int N, int[] blacklist) {
            len = N-blacklist.length;
            Set<Integer> whitelist = new HashSet<>();
            for (int i = len; i < N; i++) {
                whitelist.add(i);
            }
            for (int i : blacklist) {
                whitelist.remove(i);
            }
            Iterator<Integer> it = whitelist.iterator();
            for (int i : blacklist) {
                if (i < len) {
                    map.put(i, it.next());
                }
            }
        }

        public int pick() {
            int k = random.nextInt(len);
            return map.getOrDefault(k, k);
        }
    }

}
