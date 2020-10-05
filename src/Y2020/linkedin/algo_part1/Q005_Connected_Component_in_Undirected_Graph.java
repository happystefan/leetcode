package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q005_Connected_Component_in_Undirected_Graph {

    public int numOfComponent(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k->new HashSet<>()).add(v);
            graph.computeIfAbsent(v, k->new HashSet<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        int rslt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(graph, i, visited);
            rslt++;
        }
        return rslt;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int nxt : graph.getOrDefault(curr, new HashSet<>())) {
            if (visited[nxt]) continue;
            dfs(graph, nxt, visited);
        }
    }

}
