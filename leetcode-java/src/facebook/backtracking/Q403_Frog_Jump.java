package facebook.backtracking;

import java.util.*;

public class Q403_Frog_Jump {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int pos : stones) map.put(pos, new HashSet<>());
        map.get(0).add(0);
        for (int pos : stones) {
            for (int kk : map.get(pos)) {
                for (int k = kk-1; k <= kk+1; k++) {
                    if (k > 0 && map.containsKey(pos+k)) {
                        map.get(pos+k).add(k);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }

}
