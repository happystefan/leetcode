package Y2020.facebook.misc;

import java.util.HashSet;
import java.util.Set;

public class Q0939_Minimum_Area_Rectangle {

    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (int[] p : points) set.add(p[0] + "#" + p[1]);
        int rslt = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) continue;
                String p3 = x1 + "#" + y2;
                String p4 = x2 + "#" + y1;
                if (set.contains(p3) && set.contains(p4)) {
                    rslt = Math.min(rslt, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
        return rslt == Integer.MAX_VALUE ? 0 : rslt;
    }

}
