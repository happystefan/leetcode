package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

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
        int[] result = new int[numCourses];
        int k = 0;
        while (!Q.isEmpty()) {
            int u = Q.poll();
            result[k++] = u;
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
        return k == numCourses ? result : new int[0];
    }

}
