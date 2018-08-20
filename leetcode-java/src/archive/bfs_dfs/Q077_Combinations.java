package archive.bfs_dfs;

import java.util.*;

public class Q077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), n, 1, k);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int pos, int k) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (list.size() > k || pos > n) {
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(result, list, n, i+1, k);
            list.remove(list.size()-1);
        }
    }

}
