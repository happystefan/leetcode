package bfs_dfs;

import java.util.*;

public class Q753_Cracking_the_Safe {

    public String crackSafe(int n, int k) {
        String start = "";
        for (int i = 0; i < n - 1; i++) {
            start += "0";
        }
        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(start, visited, sb, k);
        sb.insert(0, start);
        return sb.toString();
    }

    private void dfs(String start, Set<String> visited, StringBuilder sb, int k) {
        for (int i = 0; i < k; i++) {
            String key = start + i;
            if (!visited.contains(key)) {
                visited.add(key);
                dfs(key.substring(1), visited, sb, k);
                sb.append(i);
            }
        }
    }

}
