package Y2018.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253_Meeting_Rooms_II {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pqueue = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        pqueue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = pqueue.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pqueue.add(intervals[i]);
            }
            pqueue.add(interval);
        }
        return pqueue.size();
    }

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

}
