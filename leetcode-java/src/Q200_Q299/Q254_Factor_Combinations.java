package Q200_Q299;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q254_Factor_Combinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(2, n, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(int start, int n, List<Integer> pre, List<List<Integer>> ans) {
        for (int i = start; i*i <= n; i++) {
            if (n%i == 0) {
                pre.add(i);
                pre.add(n/i);
                ans.add(new LinkedList<>(pre));
                pre.remove(pre.size()-1);
                dfs(i, n/i, pre, ans);
                pre.remove(pre.size()-1);
            }
        }
    }

}
