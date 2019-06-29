package range_query.calendar;

import java.util.TreeMap;

public class Q729_My_Calendar_I {

    class MyCalendar {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer lowerKey = map.lowerKey(end);
            if (lowerKey != null && map.get(lowerKey) > start) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

}

