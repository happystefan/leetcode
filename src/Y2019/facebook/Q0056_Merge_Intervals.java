package Y2019.facebook;

import java.util.Arrays;
import java.util.LinkedList;

public class Q0056_Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] itvl : intervals) {
            if (list.size() == 0 || itvl[0] > list.getLast()[1]) {
                list.add(itvl);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], itvl[1]);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
