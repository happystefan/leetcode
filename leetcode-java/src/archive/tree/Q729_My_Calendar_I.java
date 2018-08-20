package archive.tree;

import java.util.TreeMap;

public class Q729_My_Calendar_I {

    class MyCalendar {

        TreeMap<Integer, Integer> cal = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer lower = cal.lowerKey(end);
            if (lower == null || cal.get(lower) <= start) {
                cal.put(start, end);
                return true;
            }
            return false;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

}
