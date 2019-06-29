package Y2018.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q785_Is_Graph_Bipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);
            color[i] = 1;
            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v : graph[u]) {
                    if (color[v] == 0) {
                        color[v] = 3 - color[u];
                        Q.offer(v);
                    } else {
                        if (color[v] != 3 - color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
