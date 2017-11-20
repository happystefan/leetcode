package Q001_Q099;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mqliang on 6/4/17.
 */
public class Q039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<Integer>(), candidates, target, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> comb,  int[] candidates, int target, int begin) {
        if (target == 0) {
            ans.add(new LinkedList(comb));
            return;
        }
        for (int i = begin; i < candidates.length && target >= candidates[i]; i++) {
            comb.add(candidates[i]);
            dfs(ans, comb, candidates, target-candidates[i], i);
            comb.remove(comb.size()-1);
        }
    }
}
