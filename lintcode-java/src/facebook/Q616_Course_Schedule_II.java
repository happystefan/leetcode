package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q616_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];

        ArrayList<Integer>[] child = new ArrayList[numCourses];

        for (int[] prequisite : prerequisites) {
            degree[prequisite[0]]++;

            if (child[prequisite[1]] == null) {
                child[prequisite[1]] = new ArrayList();
            }

            child[prequisite[1]].add(prequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int k = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[k++] = cur;
            if (child[cur] == null) {
                continue;
            }
            for (int c : child[cur]) {
                degree[c]--;
                if (degree[c] == 0) {
                    queue.offer(c);
                }
            }
        }
        if (k == numCourses) {
            return result;
        }
        return new int[]{};
    }

}
