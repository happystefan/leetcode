package google;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q156_Merge_Intervals {

    public class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) ->  {
            return a.start == b.start ? a.end - b.end : a.start - b.start;
        });

        if (intervals.size() <= 1) return intervals;

        Interval newInternal = null;
        List<Interval> ans = new LinkedList<>();
        for (Interval interval : intervals) {
            if (newInternal == null) {
                newInternal = interval;
                continue;
            }
            if (newInternal.end < interval.start) {
                ans.add(newInternal);
                newInternal = interval;
            } else {
                newInternal.end = Math.max(newInternal.end, interval.end);
            }
        }
        if (newInternal != null) ans.add(newInternal);
        return ans;
    }

}
