package Y2019.Q0301_Q0600;

import java.util.*;

public class Q0310_Minimum_Height_Trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return Arrays.asList(0);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            degree[a]++;
            degree[b]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) Q.add(i);
        }
        List<Integer> result = new LinkedList<>();
        while (!Q.isEmpty()) {
            result.clear();
            int size = Q.size();
            while (size-- > 0) {
                int cur = Q.poll();
                result.add(cur);
                for (int next : map.getOrDefault(cur, new HashSet<>())) {
                    degree[next]--;
                    if (degree[next] == 1) Q.add(next);
                }
            }
        }
        return result;
    }

}
