package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), k, 1, n);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int k, int pos, int n) {
        if (list.size() == k) {
            if (n == 0) rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i <= 9; i++) {
            if (n < i) continue;
            list.add(i);
            dfs(rslt, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }
    }

}
