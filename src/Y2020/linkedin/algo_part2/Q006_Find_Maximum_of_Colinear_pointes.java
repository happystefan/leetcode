package Y2020.linkedin.algo_part2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q006_Find_Maximum_of_Colinear_pointes {

    // TC: N^3
    public int maxNumOfColinearPointes(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if (n < 2) return 0;
        int rslt = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 2;
                for (int k = j + 1; j < k; j++) {
                    if (coline(points[i], points[j], points[k])) {
                        cnt++;
                    }
                }
                rslt = Math.max(rslt, cnt);
            }
        }
        return rslt;
    }

    private boolean coline(int[] a, int[] b, int[] c) {
        if (a[0] == b[0] && a[0] == c[0]) return true;
        if (a[1] == b[1] && a[1] == c[1]) return true;
        // (a.y-b.y)/(a.x-b.x) == (a.y-c.y)/(a.x-c.x)
        return Math.abs(a[1] - b[1]) * Math.abs(a[0] - c[0]) == Math.abs(a[1] - c[1]) * Math.abs(a[0] - b[0]);
    }

    // TC: N^2
    // TODO: float point number precision issue -- should use some scientific package which provide
    //       rational number support
    public int maxNumOfColinearPointes_map(int[][] points) {
        Map<String, Set<Integer>> map = new HashMap<>();
        int n = points.length;
        if (n < 2) return 0;
        int rslt = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i], p2 = points[j];
                String hash = "";
                if (p1[0] == p2[0]) {
                    hash = "* " + p1[0];
                } else {
                    // y = slope * x + c
                    double slope = (p1[1] - p2[1]) * 1.0 / (p1[0] - p2[0]);
                    double c = p1[1] - slope * p1[0];
                    double y_intercept = (0 - c) / slope;
                    hash = slope + " " + y_intercept;
                }
                map.computeIfAbsent(hash, k -> new HashSet<>());
                map.get(hash).add(i);
                map.get(hash).add(j);
            }
        }
        for (String key : map.keySet()) {
            rslt = Math.max(rslt, map.get(key).size());
        }
        return rslt;
    }


}
