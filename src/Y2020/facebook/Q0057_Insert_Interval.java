package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0057_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rslt = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            rslt.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        rslt.add(newInterval);
        while (i < intervals.length) rslt.add(intervals[i++]);
        return rslt.toArray(new int[rslt.size()][]);
    }

}
