package archive.Q001_Q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
            indegree[prerequisite[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int[] ans = new int[numCourses];
        int idx = numCourses-1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[idx--] = cur;
            for (int i = 0; i < numCourses; i++) {
                if (graph[cur][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) queue.add(i);
                }
            }
        }
        return idx == -1 ? ans : new int[]{};
    }

}
