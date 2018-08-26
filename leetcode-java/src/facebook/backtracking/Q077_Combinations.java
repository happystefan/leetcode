package facebook.backtracking;

import java.util.*;

public class Q077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int pos, int n, int k) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(result, list, i+1, n, k);
            list.remove(list.size()-1);
        }
    }

}
