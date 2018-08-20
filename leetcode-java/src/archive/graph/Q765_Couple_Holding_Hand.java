package archive.graph;

import java.util.*;

public class Q765_Couple_Holding_Hand {

    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i += 2) {
            map.put(row[i], row[i+1]);
            map.put(row[i+1], row[i]);
        }
        int result = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (map.get(i) != i+1) {
                int curr = map.get(i);
                int next = map.get(i+1);
                map.put(curr, next);
                map.put(next, curr);
                result++;
            }
        }
        return result;
    }

}
