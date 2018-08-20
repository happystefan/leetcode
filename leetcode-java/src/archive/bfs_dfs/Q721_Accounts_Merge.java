package archive.bfs_dfs;

import java.util.*;

public class Q721_Accounts_Merge {

    Map<String, Set<String>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            Set<String> set = new HashSet<>(account);
            set.remove(account.get(0));
            for (int i = 1; i < account.size(); i++) {
                Set<String> tmp = new HashSet<>(set);
                tmp.remove(account.get(i));
                map.computeIfAbsent(account.get(i), k -> new HashSet<>());
                map.get(account.get(i)).addAll(tmp);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (List<String> account : accounts) {
            if (visited.contains(account.get(1))) {
                continue;
            }
            List<String> list = new LinkedList<>();
            dfs(list, account.get(1));
            Collections.sort(list);
            list.add(0, account.get(0));
            result.add(list);
        }
        return result;
    }

    private void dfs(List<String> list, String u) {
        list.add(u);
        visited.add(u);
        if (!map.containsKey(u)) {
            return;
        }
        for (String v : map.get(u)) {
            if (visited.contains(v)) {
                continue;
            }
            dfs(list, v);
        }
    }

}
