package Y2020.facebook.misc;

import java.util.Arrays;

public class Q0435_Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int rslt = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] itv = intervals[i];
            while (i + 1 < intervals.length && intervals[i + 1][0] < itv[1]) {
                rslt++;
                i++;
            }
        }
        return rslt;
    }

}
