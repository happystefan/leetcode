package Y2018.facebook;

import java.util.*;

public class Q210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int a = pair[0], b = pair[1];
            map.computeIfAbsent(b, k -> new HashSet<>());
            map.get(b).add(a);
            degree[a]++;
        }
        int[] result = new int[numCourses];
        int k = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) Q.offer(i);
        }
        while (!Q.isEmpty()) {
            int u = Q.poll();
            result[k++] = u;
            for (int v : map.getOrDefault(u, new HashSet<>())) {
                degree[v]--;
                if (degree[v] == 0) Q.offer(v);
            }
        }
        return k == numCourses ? result : new int[]{};
    }

}
