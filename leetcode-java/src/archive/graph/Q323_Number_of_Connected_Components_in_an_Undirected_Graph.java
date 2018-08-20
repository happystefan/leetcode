package archive.graph;

import java.util.*;

public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {

    public int countComponents(int n, int[][] edges) {
        Set<Integer>[] neighbors = new Set[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            neighbors[u].add(v);
            neighbors[v].add(u);
        }

        int[] visited = new int[n];
        int result = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                Q.add(i);
                result++;
            }
            while (!Q.isEmpty()) {
                int u = Q.poll();
                visited[u] = 1;
                for (int v : neighbors[u]) {
                    if (visited[v] == 0) {
                        Q.offer(v);
                    }
                }
            }
        }
        return result;
    }

}
