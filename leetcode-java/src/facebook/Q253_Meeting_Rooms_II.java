package facebook;

import java.util.*;

public class Q253_Meeting_Rooms_II {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0)+1);
            map.put(interval.end, map.getOrDefault(interval.end, 0)-1);
        }
        int result = 0, ongoing = 0;
        for (int time : map.keySet()) {
            ongoing += map.get(time);
            result = Math.max(result, ongoing);
        }
        return result;
    }

}
