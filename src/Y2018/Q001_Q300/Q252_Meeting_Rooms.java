package Y2018.Q001_Q300;

import java.util.Arrays;

public class Q252_Meeting_Rooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 0; i + 1 < intervals.length; i++) {
            if (intervals[i + 1].start < intervals[i].end) return false;
        }
        return true;
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
