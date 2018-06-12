package tree;

import java.util.Map;
import java.util.TreeMap;

public class Q846_Hand_of_Straights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int i = first; i < first+W; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                int cnt = map.get(i);
                if (cnt == 1) {
                    map.remove(i);
                } else {
                    map.put(i, cnt-1);
                }
            }
        }
        return true;
    }

}
