package Y2020.facebook;

import java.util.*;

public class Q0261_Graph_Valid_Tree {

    class solution1_dfs {

        public boolean validTree(int n, int[][] edges) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            }
            Set<Integer> visited = new HashSet<>();
            return dfs(graph, 0, -1, visited) && visited.size() == n;
        }

        private boolean dfs(Map<Integer, Set<Integer>> graph, int cur, int pre, Set<Integer> visited) {
            if (visited.contains(cur)) return false;
            visited.add(cur);
            for (int nxt : graph.getOrDefault(cur, new HashSet<>())) {
                if (nxt == pre) continue;
                if (!dfs(graph, nxt, cur, visited)) return false;
            }
            return true;
        }

    }

    class solution2_union_found {

        public boolean validTree(int n, int[][] edges) {
            int[] p = new int[n];
            Arrays.fill(p, -1);
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                int px = findp(x, p), py = findp(y, p);
                if (px == py) return false;
                p[px] = py;
            }
            return edges.length == n - 1;
        }

        private int findp(int x, int[] p) {
            return (p[x] == -1) ? x : findp(p[x], p);
        }

    }

}
