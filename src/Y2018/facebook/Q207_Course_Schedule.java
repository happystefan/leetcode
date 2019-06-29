package Y2018.facebook;

import java.util.*;

public class Q207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int a = pair[0], b = pair[1];
            map.computeIfAbsent(a, k -> new HashSet<>());
            map.get(a).add(b);
            degree[b]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) Q.offer(i);
        }
        int cnt = 0;
        while (!Q.isEmpty()) {
            int u = Q.poll();
            cnt++;
            for (int v : map.getOrDefault(u, new HashSet<>())) {
                degree[v]--;
                if (degree[v] == 0) Q.offer(v);
            }
        }
        return cnt == numCourses;
    }

}
