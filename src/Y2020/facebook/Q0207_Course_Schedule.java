package Y2020.facebook;

import java.util.*;

public class Q0207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] uv : prerequisites) {
            int u = uv[0], v = uv[1];
            graph.computeIfAbsent(u, k->new HashSet<>()).add(v);
            degree[v]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) Q.add(i);
        }
        int cnt = 0;
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            cnt++;
            for (int nxt : graph.getOrDefault(cur, new HashSet<>())) {
                degree[nxt]--;
                if (degree[nxt] == 0) Q.add(nxt);
            }
        }
        return cnt == numCourses;
    }

}
