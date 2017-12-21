package google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q030_Insert_Interval_B {

    public class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new LinkedList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || newInterval.start > interval.end) {
                ans.add(interval);
            } else if (interval.start > newInterval.end) {
                ans.add(newInterval);
                newInterval = null;
                ans.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) ans.add(newInterval);
        return ans;
    }

}
