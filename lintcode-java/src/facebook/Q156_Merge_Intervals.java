package facebook;

import java.util.LinkedList;
import java.util.List;

public class Q156_Merge_Intervals {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new LinkedList<>();
        Interval newInterval = null;
        for (Interval interval : intervals) {
            if (newInterval == null) {
                newInterval = interval;
                continue;
            }
            if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }

}
