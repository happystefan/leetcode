package archive.dp;

import java.util.*;

public class Q403_Frog_Jump {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int pos : stones){
            dp.put(pos, new HashSet<>());
        }
        dp.get(0).add(0);
        for (int i = 0; i < stones.length-1; i++) {
            for (int kk : dp.get(i)) {
                for (int k = kk-1; k <= kk+1; k++) {
                    if (k > 0 && dp.containsKey(stones[i]+k)) {
                        dp.get(stones[i]+k).add(k);
                    }
                }
            }
        }
        return dp.get(stones[stones.length-1]).size() > 0;
    }

}
