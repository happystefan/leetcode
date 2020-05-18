package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q0882_Reachable_Nodes_In_Subdivided_Graph {

    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            map.computeIfAbsent(a, k -> new HashMap<>()).put(b, c);
            map.computeIfAbsent(b, k -> new HashMap<>()).put(a, c);
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Q.add(new int[]{0, M});

        Map<Integer, Integer> seen = new HashMap<>();
        while (!Q.isEmpty()) {
            int[] pair = Q.poll();
            int curr = pair[0], move = pair[1];
            if (seen.containsKey(curr)) continue;
            seen.put(curr, move);
            Map<Integer, Integer> neigh = map.getOrDefault(curr, new HashMap<>());
            for (int next : neigh.keySet()) {
                int cost = neigh.get(next) + 1;
                if (move >= cost && !seen.containsKey(next)) {
                    Q.add(new int[]{next, move - cost});
                }
            }
        }
        int rslt = seen.size();
        for (int[] edge : edges) {
            int a = seen.getOrDefault(edge[0], 0);
            int b = seen.getOrDefault(edge[1], 0);
            rslt += Math.min(a + b, edge[2]);
        }
        return rslt;
    }

}
