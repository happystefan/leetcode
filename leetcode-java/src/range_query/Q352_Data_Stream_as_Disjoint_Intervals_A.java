package range_query;

import java.util.*;

public class Q352_Data_Stream_as_Disjoint_Intervals_A {

    // Definition for an interval.
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class SummaryRanges {

        TreeSet<Integer> set = new TreeSet<>();

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            set.add(val);
        }


        public List<Interval> getIntervals() {
            List<Integer> list = new ArrayList<>(set);
            List<Interval> result = new LinkedList<>();
            int i = 0, j = 0;
            while (j < list.size()) {
                while (j + 1 < list.size() && list.get(j + 1) == list.get(j) + 1) {
                    j++;
                }
                result.add(new Interval(list.get(i), list.get(j)));
                j++;
                i = j;
            }
            return result;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

}
