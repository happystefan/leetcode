package Y2019.facebook;

import java.util.Map;
import java.util.TreeMap;

public class Q0253_Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] itvl : intervals) {
            map.put(itvl[0], map.getOrDefault(itvl[0], 0) + 1);
            map.put(itvl[1], map.getOrDefault(itvl[1], 0) - 1);
        }
        int max = 0, cnt = 0;
        for (int i : map.keySet()) {
            cnt += map.get(i);
            max = Math.max(max, cnt);
        }
        return max;
    }

}
