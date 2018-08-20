package archive.graph;

import java.util.*;

public class Q802_Find_Eventual_Safe_States {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> parents = new HashMap<>();
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                degree[u] += 1;
                parents.computeIfAbsent(v, k -> new HashSet<>());
                parents.get(v).add(u);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                Q.offer(i);
            }
        }
        List<Integer> result = new LinkedList<>();
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int v = Q.poll();
                result.add(v);
                if (!parents.containsKey(v)) {
                    continue;
                }
                for (int u : parents.get(v)) {
                    degree[u]--;
                    if (degree[u] == 0) {
                        Q.offer(u);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

}
