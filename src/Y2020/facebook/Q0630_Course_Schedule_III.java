package Y2020.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q0630_Course_Schedule_III {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> b - a);
        int clock = 0;
        for (int[] course : courses) {
            clock += course[0];
            Q.add(course[0]);
            if (clock > course[1]) clock -= Q.poll();
        }
        return Q.size();
    }

}
