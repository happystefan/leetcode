package tree;

import java.util.LinkedList;
import java.util.List;

public class Q731_My_Calendar_II {

    class MyCalendarTwo {

        List<int[]> cal = new LinkedList<>();
        List<int[]> ovp = new LinkedList<>();
        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            for (int[] iv : ovp) {
                if (iv[0] < end && start < iv[1]) {
                    return false;
                }
            }
            for (int[] iv : cal) {
                if (iv[0] < end && start < iv[1]) {
                    ovp.add(new int[]{ Math.max(start, iv[0]), Math.min(end, iv[1])});
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
