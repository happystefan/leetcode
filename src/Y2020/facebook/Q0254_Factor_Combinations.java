package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0254_Factor_Combinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), 2, n);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int start, int n) {
        if (n == 1) {
            if (list.size() > 1) rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i != 0) continue;
            list.add(i);
            dfs(rslt, list, i, n / i);
            list.remove(list.size() - 1);
        }
    }

}
