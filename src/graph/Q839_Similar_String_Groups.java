package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q839_Similar_String_Groups {

    public int numSimilarGroups(String[] A) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isSimiliar(A[i], A[j])) {
                    graph.computeIfAbsent(A[i], k -> new HashSet<>());
                    graph.computeIfAbsent(A[j], k -> new HashSet<>());
                    graph.get(A[i]).add(A[j]);
                    graph.get(A[j]).add(A[i]);
                }
            }
        }
        int result = 0;
        Set<String> visited = new HashSet<>();
        for (String str : A) {
            if (visited.contains(str)) {
                continue;
            }
            dfs(str, graph, visited);
            result++;
        }
        return result;
    }

    private void dfs(String u, Map<String, Set<String>> graph, Set<String> visited) {
        visited.add(u);
        if (!graph.containsKey(u)) {
            return;
        }
        for (String v : graph.get(u)) {
            if (visited.contains(v)) {
                continue;
            }
            dfs(v, graph, visited);
        }
    }

    private boolean isSimiliar(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 2;
    }

}
