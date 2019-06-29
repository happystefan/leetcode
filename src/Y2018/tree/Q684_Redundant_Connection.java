package Y2018.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q684_Redundant_Connection {

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[][] graph = new int[N + 1][N + 1];
        int[] degree = new int[N + 1];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u] += 1;
            degree[v] += 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 1) {
                Q.offer(i);
            }
        }
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v = 0; v <= N; v++) {
                if (graph[u][v] == 1) {
                    graph[u][v] = 0;
                    graph[v][u] = 0;
                    degree[v]--;
                    if (degree[v] == 1) {
                        Q.offer(v);
                    }
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (graph[edge[0]][edge[1]] == 1) {
                return edge;
            }
        }
        return null;
    }

}
