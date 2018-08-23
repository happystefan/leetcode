package facebook;

import java.util.*;

public class Q886_Possible_Bipartition {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);
            color[i] = 1;
            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v : graph[u]) {
                    if (color[v] != 0 && color[v] != 3-color[u]) {
                        return false;
                    }
                    if (color[v] != 0) continue;
                    color[v] = 3-color[u];
                    Q.offer(v);
                }
            }
        }
        return true;
    }

}
