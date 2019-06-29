package Y2018.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q743_Network_Delay_Time {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }
        Set<Integer> visited = new HashSet<>();
        for (int[] pair : times) {
            int u = pair[0], v = pair[1], w = pair[2];
            graph[u][v] = w;
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Q.offer(new int[]{K, 0});

        int w = 0;
        while (!Q.isEmpty()) {
            int[] pair = Q.poll();
            int u = pair[0];
            w = pair[1];
            visited.add(u);
            if (visited.size() == N) {
                return w;
            }
            for (int v = 1; v <= N; v++) {
                if (!visited.contains(v) && graph[u][v] != -1) {
                    Q.offer(new int[]{v, w + graph[u][v]});
                }
            }
        }
        return -1;
    }

}
