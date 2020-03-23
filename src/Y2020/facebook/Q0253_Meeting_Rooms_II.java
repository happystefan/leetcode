package Y2020.facebook;

import java.util.TreeMap;

public class Q0253_Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] pair : intervals) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + 1);
            map.put(pair[1], map.getOrDefault(pair[1], 0) - 1);
        }
        int ongoing = 0, rslt = 0;
        for (int i : map.values()) {
            ongoing += i;
            rslt = Math.max(rslt, ongoing);
        }
        return rslt;
    }

}
