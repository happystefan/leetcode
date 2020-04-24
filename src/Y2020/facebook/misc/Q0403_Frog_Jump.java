package Y2020.facebook.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0403_Frog_Jump {

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) map.put(stone, new HashSet<>());
        map.get(0).add(0);
        for (int stone : stones) {
            for (int kk : map.get(stone)) {
                for (int k = kk - 1; k <= kk + 1; k++) {
                    if (k > 0 && map.containsKey(stone + k)) {
                        map.get(stone + k).add(k);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() != 0;
    }

}
