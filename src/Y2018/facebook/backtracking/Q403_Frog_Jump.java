package Y2018.facebook.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q403_Frog_Jump {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int pos : stones) map.put(pos, new HashSet<>());
        map.get(0).add(0);
        for (int pos : stones) {
            for (int kk : map.get(pos)) {
                for (int k = kk - 1; k <= kk + 1; k++) {
                    if (k > 0 && map.containsKey(pos + k)) {
                        map.get(pos + k).add(k);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }

}
