package Y2020.facebook.misc;

import java.util.*;

public class Q0721_Accounts_Merge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                map.put(account.get(i), name);
                if (i == 1) continue;
                String a = account.get(i - 1), b = account.get(i);
                graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> rslt = new LinkedList<>();
        for (String email : map.keySet()) {
            if (visited.contains(email)) continue;
            List<String> list = new LinkedList<>();
            dfs(list, email, graph, visited);
            Collections.sort(list);
            list.add(0, map.get(email));
            rslt.add(list);
        }
        return rslt;
    }

    private void dfs(List<String> list, String email, Map<String, Set<String>> graph, Set<String> visited) {
        list.add(email);
        for (String next : graph.getOrDefault(email, new HashSet<>())) {
            if (visited.contains(next)) continue;
            dfs(list, next, graph, visited);
        }
    }

}
