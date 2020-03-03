package Y2020.facebook;

import java.util.*;

public class Q0210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] uv : prerequisites) {
            int u = uv[0], v = uv[1];
            graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            degree[v]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) Q.add(i);
        }
        int[] rslt = new int[numCourses];
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            rslt[--numCourses] = cur;
            for (int nxt : graph.getOrDefault(cur, new HashSet<>())) {
                degree[nxt]--;
                if (degree[nxt] == 0) Q.add(nxt);
            }
        }
        return numCourses == 0 ? rslt : new int[]{};
    }

}
