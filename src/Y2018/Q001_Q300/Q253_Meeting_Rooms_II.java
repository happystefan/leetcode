package Y2018.Q001_Q300;

import java.util.Arrays;

public class Q253_Meeting_Rooms_II {

    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int ans = 0, idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[idx]) {
                ans++;
            } else {
                idx++;
            }
        }
        return ans;
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
