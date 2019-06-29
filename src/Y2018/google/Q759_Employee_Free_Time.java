package Y2018.google;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q759_Employee_Free_Time {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new LinkedList<>();
        List<Interval> result = new LinkedList<>();
        for (List<Interval> period : schedule) {
            intervals.addAll(period);
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                result.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
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
