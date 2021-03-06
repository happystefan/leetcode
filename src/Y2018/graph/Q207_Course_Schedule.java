package Y2018.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] neighbors = new LinkedList[numCourses];
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            int u = p[0], v = p[1];
            if (neighbors[v] == null) {
                neighbors[v] = new LinkedList<>();
            }
            neighbors[v].add(u);
            degree[u]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                Q.offer(i);
            }
        }
        int cnt = 0;
        while (!Q.isEmpty()) {
            int u = Q.poll();
            cnt++;
            if (neighbors[u] == null) {
                continue;
            }
            for (int v : neighbors[u]) {
                degree[v]--;
                if (degree[v] == 0) {
                    Q.offer(v);
                }
            }
        }
        return cnt == numCourses;
    }

}
