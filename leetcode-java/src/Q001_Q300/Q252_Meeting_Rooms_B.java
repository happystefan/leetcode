package Q001_Q300;

import java.util.Arrays;

public class Q252_Meeting_Rooms_B {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i+1 < intervals.length; i++) {
            if (start[i+1] < end[i]) return false;
        }
        return true;
    }

}
