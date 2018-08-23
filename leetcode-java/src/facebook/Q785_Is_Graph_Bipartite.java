package facebook;

import java.util.*;

public class Q785_Is_Graph_Bipartite {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : dislikes) {
            int u = pair[0], v = pair[1];
            map.computeIfAbsent(u, k -> new HashSet<>());
            map.computeIfAbsent(v, k -> new HashSet<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int[] color = new int[N+1];
        for (int i : map.keySet()) {
            if (color[i] != 0) continue;
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);
            color[i] = 1;
            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v : map.get(u)) {
                    if (color[v] != 0 && color[v] != 3-color[u]) return false;
                    if (color[v] != 0) continue;
                    color[v] = 3-color[u];
                    Q.offer(v);
                }
            }
        }
        return true;
    }

}
