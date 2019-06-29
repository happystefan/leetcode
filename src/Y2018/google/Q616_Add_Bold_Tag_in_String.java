package Y2018.google;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q616_Add_Bold_Tag_in_String {

    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new LinkedList<>();
        for (String word : dict) {
            int idx = s.indexOf(word);
            while (idx != -1) {
                intervals.add(new Interval(idx, idx + word.length()));
                idx = s.indexOf(word, idx + 1);
            }
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        intervals = merge(intervals);

        int pre = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(s.substring(pre, interval.start));
            sb.append("<b>" + s.substring(interval.start, interval.end) + "</b>");
            pre = interval.end;
        }
        if (pre < s.length()) {
            sb.append(s.substring(pre));
        }
        return sb.toString();
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        for (Interval interval : intervals) {
            if (result.size() == 0) {
                result.add(interval);
            } else {
                if (interval.start > result.get(result.size() - 1).end) {
                    result.add(interval);
                } else {
                    result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, interval.end);
                }
            }
        }
        return result;
    }

    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
