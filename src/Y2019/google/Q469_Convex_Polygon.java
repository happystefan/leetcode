package Y2019.google;

import java.util.List;

public class Q469_Convex_Polygon {

    private int calDir(List<Integer> a, List<Integer> b, List<Integer> c) {
        int ai = a.get(0), aj = a.get(1);
        int bi = b.get(0), bj = b.get(1);
        int ci = c.get(0), cj = c.get(1);
        int[] v1 = new int[]{bi - ai, bj - aj};
        int[] v2 = new int[]{ci - bi, cj - bj};
        int dir = v1[0] * v2[1] - v1[1] * v2[0];
        return Integer.compare(dir, 0);
    }

    public boolean isConvex(List<List<Integer>> points) {
        int prev_dir = 0;
        int n = points.size();
        for (int i = 0; i < n; i++) {
            List<Integer> a = points.get(i % n);
            List<Integer> b = points.get((i + 1) % n);
            List<Integer> c = points.get((i + 2) % n);
            int cur_dir = calDir(a, b, c);
            if (cur_dir == 0) continue;
            if (prev_dir * cur_dir < 0) return false;
            prev_dir = cur_dir;
        }
        return true;
    }

}
