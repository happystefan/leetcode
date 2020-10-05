package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q004_Valid_Tree {

    class solution_valid_tree_undirected_graph {

        // is a tree if all the node is connected with someone else and has no cycles.
        // then, from any node, can traverse to all other nodes.
        boolean isTree(int n, int[][] edges) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
                graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
            }
            boolean[] visited = new boolean[n];

            boolean hasCycles = dfs(graph, visited, 0, -1);
            if (hasCycles) return false;

            for (boolean v : visited) {
                if (!v) return false;
            }

            return true;
        }

        // O(N+E)

        private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int curr, int prev) {
            if (visited[curr]) return true;
            visited[curr] = true;
            for (int nxt : graph.getOrDefault(curr, new HashSet<>())) {
                if (nxt != prev && dfs(graph, visited, nxt, curr)) return true;
            }
            return false;
        }


        class solution_valid_tree_directed_graph {

            // only one node has 0 in-degree, this node is the root.
            // and from this node, can traverse to all other nodes.
            boolean isTree(int n, int[][] edges) {
                Map<Integer, Set<Integer>> graph = new HashMap<>();
                int[] degree = new int[n];
                for (int[] edge : edges) {
                    int u = edge[0], v = edge[1];
                    graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
                    degree[v]++;
                }
                boolean[] visited = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (degree[i] == 0) {
                        dfs(graph, visited, 0);
                        break;
                    }
                }
                for (boolean v : visited) {
                    if (!v) return false;
                }
                return true;
            }

            private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int i) {
                visited[i] = true;
                for (int v : graph.getOrDefault(i, new HashSet<>())) {
                    if (visited[v]) continue;
                    dfs(graph, visited, v);
                }
            }

        }

        // O(N+E)
    }

}