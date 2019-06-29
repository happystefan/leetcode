package range_query;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Q352_Data_Stream_as_Disjoint_Intervals_B {

    // Definition for an interval.
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

    class SummaryRanges {

        TreeMap<Integer, Interval> map = new TreeMap<>();

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            if (map.containsKey(val)) {
                return;
            }
            Integer l = map.lowerKey(val);
            Integer h = map.higherKey(val);
            if (l != null && h != null && map.get(l).end + 1 == val && h - 1 == val) {
                map.get(l).end = map.get(h).end;
                map.remove(h);
            } else if (l != null && map.get(l).end + 1 >= val) {
                map.get(l).end = Math.max(map.get(l).end, val);
            } else if (h != null && h - 1 == val) {
                map.put(val, new Interval(val, map.get(h).end));
                map.remove(h);
            } else {
                map.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new LinkedList<>(map.values());
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

}
