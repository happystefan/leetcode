package dp;

import java.util.*;

public class Q740_Delete_and_Earn {

    // DFS with prune: Time Limit Exceeded
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return dfs(map);
    }

    private int dfs(Map<Integer, Integer> map) {
        int result = 0;
        for (int i : map.keySet()) {
            Map<Integer, Integer> new_map = new HashMap<>(map);
            new_map.remove(i);
            new_map.remove(i-1);
            new_map.remove(i+1);
            result = Math.max(result, i*map.get(i)+dfs(new_map));
        }
        return result;
    }

}
