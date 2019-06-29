package Y2018.facebook.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q743_Network_Delay_Time {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) Arrays.fill(graph[i], -1);
        for (int[] time : times) graph[time[0]][time[1]] = time[2];
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Set<Integer> visited = new HashSet<>();
        Q.offer(new int[]{K, 0});
        int result = 0;
        while (!Q.isEmpty()) {
            int u = Q.peek()[0], d = Q.peek()[1];
            Q.poll();
            if (visited.contains(u)) continue;
            visited.add(u);
            result = Math.max(result, d);
            for (int v = 1; v <= N; v++) {
                if (graph[u][v] != -1 && !visited.contains(v)) {
                    Q.offer(new int[]{v, d + graph[u][v]});
                }
            }
        }
        return visited.size() == N ? result : -1;
    }

}
