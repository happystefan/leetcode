package Y2018.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q847_Shortest_Path_Visiting_All_Nodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            Q.offer(new int[]{1 << i, i});
        }
        while (!Q.isEmpty()) {
            int[] pair = Q.poll();
            int path = pair[0], u = pair[1];
            for (int v : graph[u]) {
                int next_path = path | (1 << v);
                if (dp[v][next_path] > dp[u][path] + 1) {
                    dp[v][next_path] = dp[u][path] + 1;
                    Q.offer(new int[]{next_path, v});
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[i][(1 << n) - 1]);
        }
        return result;
    }

}
