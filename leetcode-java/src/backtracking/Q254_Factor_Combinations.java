package backtracking;

import java.util.*;

public class Q254_Factor_Combinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 2, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> combs, int start, int n) {
        if (n == 1) {
            if (combs.size() > 1) {
                result.add(new LinkedList<>(combs));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                combs.add(i);
                dfs(result, combs, i, n/i);
                combs.remove(combs.size()-1);
            }
        }
    }

}
