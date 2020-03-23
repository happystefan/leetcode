package Y2020.facebook;

import java.util.Arrays;

public class Q0252_Meeting_Rooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < intervals.length -1 ; i++) {
            if (intervals[i + 1][0] < intervals[i][1]) return false;
        }
        return true;
    }

}
