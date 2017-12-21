import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q030_Insert_Interval {

    public class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> ans = new LinkedList<>();
        if (intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }

        int newStart = newInterval.start, newEnd = newInterval.end;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                ans.add(new Interval(interval.start, interval.end));
            }
            if (interval.start > newInterval.end) {
                ans.add(new Interval(interval.start, interval.end));
            }
            if (newInterval.start >= interval.start && newInterval.start <= interval.end) {
                newStart = interval.start;
            }
            if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
                newEnd = interval.end;
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).start > newEnd) {
                ans.add(i, new Interval(newStart, newEnd));
                break;
            }
        }
        if (ans.size() == 0 || newStart > ans.get(ans.size()-1).end) ans.add(new Interval(newStart, newEnd));

        return ans;
    }

}
