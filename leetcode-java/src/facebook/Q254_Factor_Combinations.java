package facebook;

import java.util.*;

public class Q254_Factor_Combinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 2, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int n) {
        if (n == 1) {
            if (list.size() > 1) result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n %i != 0) continue;
            list.add(i);
            dfs(result, list, i, n/i);
            list.remove(list.size()-1);
        }
    }

}
