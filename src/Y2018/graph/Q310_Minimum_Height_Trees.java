package Y2018.graph;

import java.util.*;

public class Q310_Minimum_Height_Trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] neighbors = new Set[n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (neighbors[u] == null) neighbors[u] = new HashSet<>();
            if (neighbors[v] == null) neighbors[v] = new HashSet<>();
            neighbors[u].add(v);
            neighbors[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                Q.add(i);
            }
        }
        while (nodes.size() > 2) {
            int size = Q.size();
            while (size-- > 0) {
                int u = Q.poll();
                nodes.remove(u);
                if (neighbors[u] == null) {
                    continue;
                }
                for (int v : neighbors[u]) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        Q.offer(v);
                    }
                }
            }
        }
        List<Integer> result = new LinkedList<>(nodes);
        return result;
    }

}
