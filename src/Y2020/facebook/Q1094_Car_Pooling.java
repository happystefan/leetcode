package Y2020.facebook;

import java.util.TreeMap;

public class Q1094_Car_Pooling {

    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int num = trip[0], i = trip[1], j = trip[2];
            map.put(i, map.getOrDefault(i, 0) + num);
            map.put(j, map.getOrDefault(j, 0) - num);
        }
        int num = 0;
        for (int i : map.values()) {
            num += i;
            if (num > capacity) return false;
        }
        return true;
    }

}
