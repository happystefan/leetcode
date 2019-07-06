package Y2019.google;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q1066_Campus_Bikes_II {

    private int dis(int[][] workers, int[][] bikes, int i, int j) {
        return Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> {
            int cmp0 = Integer.compare(a[0], b[0]);
            int cmp1 = Integer.compare(a[1], b[1]);
            int cmp2 = Integer.compare(a[2], b[2]);
            return cmp0 != 0 ? cmp0 :
                    cmp1 != 0 ? cmp1 : cmp2;
        });
        Q.add(new int[]{0, 0, 0});
        Set<Integer>[] seen = new Set[workers.length];
        for (int i = 0; i < workers.length; i++) seen[i] = new HashSet<>();
        while (true) {
            int[] pair = Q.poll();
            int cost = pair[0], i = pair[1], taken = pair[2];
            if (i == workers.length) return cost;
            if (seen[i].contains(taken)) continue;
            seen[i] = new HashSet();
            seen[i].add(taken);
            for (int j = 0; j < bikes.length; j++) {
                if ((taken & (1 << j)) != 0) continue; // bike i has been taken
                Q.add(new int[]{cost + dis(workers, bikes, i, j), i + 1, taken | (1 << j)});
            }
        }
    }

}
