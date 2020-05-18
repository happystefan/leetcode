package Y2020.facebook.misc;

import java.util.Arrays;

public class Q0452_Minimum_Number_of_Arrows_to_Burst_Balloons {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int rslt = 1, pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (pos >= points[i][0]) continue;
            rslt++;
            pos = points[i][1];
        }
        return rslt;
    }

}
