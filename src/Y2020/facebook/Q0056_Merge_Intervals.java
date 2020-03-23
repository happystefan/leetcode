package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0056_Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> rslt = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] newInternals = intervals[i];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= newInternals[1]) {
                newInternals[1] = Math.max(newInternals[1], intervals[i + 1][1]);
                i++;
            }
            rslt.add(newInternals);
        }
        return rslt.toArray(new int[rslt.size()][]);
    }

}
