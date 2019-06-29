package range_query.calendar;

import java.util.HashSet;
import java.util.Set;

public class Q731_My_Calendar_II {

    class MyCalendarTwo {

        Set<int[]> cal = new HashSet<>();
        Set<int[]> ovp = new HashSet<>();

        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            for (int[] interval : ovp) {
                if (interval[0] < end && interval[1] > start) {
                    return false;
                }
            }
            for (int[] interval : cal) {
                if (interval[0] < end && interval[1] > start) {
                    ovp.add(new int[]{Math.max(interval[0], start), Math.min(interval[1], end)});
                }
            }
            cal.add(new int[]{start, end});
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

}
