package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0056_Merge_Intervals {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int[][] merge_version1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[i + 1][1]);
                i++;
            }
            result.add(interval);
        }
        return result.toArray(new int[result.size()][]);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < intervals.length; /* empty here*/) {
            int[] interval = intervals[i];
            while (i < intervals.length && intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
                i++;
            }
            result.add(interval);
        }
        return result.toArray(new int[result.size()][]);
    }

}
