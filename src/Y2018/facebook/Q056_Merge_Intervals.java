package Y2018.facebook;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q056_Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        List<Interval> result = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            while (i + 1 < intervals.size() && intervals.get(i + 1).start <= interval.end) {
                interval.end = Math.max(interval.end, intervals.get(i + 1).end);
                i++;
            }
            result.add(interval);
        }
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
