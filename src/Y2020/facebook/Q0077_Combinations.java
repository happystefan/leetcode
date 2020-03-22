package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), 1, n, k);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int pos, int n, int k) {
        if (list.size() == k) {
            rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(rslt, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

}
