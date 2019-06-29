package Y2018.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int k, int n) {
        if (list.size() == k) {
            if (n == 0) result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(result, list, i, k, n - i);
            list.remove(list.size() - 1);
        }
    }

}
