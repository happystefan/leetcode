package Y2020.facebook.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0056_Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> rslt = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] itv = intervals[i];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= itv[1]) {
                itv[1] = Math.max(itv[1], intervals[i + 1][1]);
                i++;
            }
            rslt.add(itv);
        }
        return rslt.toArray(new int[rslt.size()][]);
    }

}
