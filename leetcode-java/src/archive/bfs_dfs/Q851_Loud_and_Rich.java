package archive.bfs_dfs;

import java.util.*;

public class Q851_Loud_and_Rich {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] degree = new int[n];
        for (int[] pair : richer) {
            int u = pair[0], v = pair[1];
            degree[v]++;
            map.computeIfAbsent(u, k -> new HashSet<>());
            map.get(u).add(v);
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                Q.offer(i);
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        while (!Q.isEmpty()) {
            int u = Q.poll();
            if (!map.containsKey(u)) {
                continue;
            }
            for (int v : map.get(u)) {
                if (quiet[result[u]] < quiet[result[v]]) {
                    result[v] = result[u];
                }
                degree[v]--;
                if (degree[v] == 0) {
                    Q.offer(v);
                }
            }
        }
        return result;
    }

}
