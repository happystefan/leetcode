package google;

import java.util.LinkedList;
import java.util.List;

public class Q056_Merge_Intervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> {
            return a.start == b.start ? a.end-b.end : a.start-b.start;
        });

        Interval newInterval = null;
        List<Interval> ans = new LinkedList<>();
        for (Interval interval : intervals) {
            if (newInterval == null) {
                newInterval = interval;
                continue;
            }
            if (newInterval.end < interval.start) {
                ans.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) ans.add(newInterval);
        return ans;
    }

}
