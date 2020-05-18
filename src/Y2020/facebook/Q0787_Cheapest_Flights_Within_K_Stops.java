package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q0787_Cheapest_Flights_Within_K_Stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            int a = f[0], b = f[1], p = f[2];
            map.computeIfAbsent(a, k -> new HashMap<>()).put(b, p);
        }
        Queue<int[]> Q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Q.add(new int[]{0, src, K + 1});
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int price = cur[0], city = cur[1], stop = cur[2];
            if (city == dst) return price;
            if (stop == 0) continue;
            Map<Integer, Integer> neigh = map.getOrDefault(city, new HashMap<>());
            for (int next : neigh.keySet()) {
                Q.add(new int[]{price + neigh.get(next), next, stop - 1});
            }
        }
        return -1;
    }

}
