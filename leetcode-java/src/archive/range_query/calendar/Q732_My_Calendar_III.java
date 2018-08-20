package archive.range_query.calendar;

import java.util.*;

public class Q732_My_Calendar_III {

    class MyCalendarThree {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0)+1);
            map.put(end, map.getOrDefault(end, 0)-1);
            int result = 0, ongoing = 0;
            for (int v : map.values()) {
                ongoing += v;
                result = Math.max(result, ongoing);
            }
            return result;
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

}
