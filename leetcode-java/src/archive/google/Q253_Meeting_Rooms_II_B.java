package archive.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253_Meeting_Rooms_II_B {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pqueue = new PriorityQueue<>(intervals.length, (a, b) -> b.end - a.end);
        int ans = 0;
        for (Interval interval : intervals) {
            while (!pqueue.isEmpty() && interval.start >= pqueue.peek().end) {
                pqueue.poll();
            }
            pqueue.add(interval);
            ans = Math.max(ans, pqueue.size());
        }
        return ans;
    }

}
