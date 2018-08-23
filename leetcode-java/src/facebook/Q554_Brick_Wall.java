package facebook;

import java.util.*;

public class Q554_Brick_Wall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size()-1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int result = wall.size();
        for (int v : map.values()) {
            result = Math.min(result, wall.size()-v);
        }
        return result;
    }

}
