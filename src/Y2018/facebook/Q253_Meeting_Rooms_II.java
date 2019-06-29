package Y2018.facebook;

import java.util.TreeMap;

public class Q253_Meeting_Rooms_II {

    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int result = 0, ongoing = 0;
        for (int i : map.values()) {
            ongoing += i;
            result = Math.max(result, ongoing);
        }
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
