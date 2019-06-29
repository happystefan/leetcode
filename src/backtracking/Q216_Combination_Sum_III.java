package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), k, n, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int k, int n, int pos) {
        if (list.size() == k && n == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i <= 9; i++) {
            if (n - i < 0) {
                continue;
            }
            list.add(i);
            dfs(result, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
