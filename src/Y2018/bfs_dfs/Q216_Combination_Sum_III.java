package Y2018.bfs_dfs;

import java.util.LinkedList;
import java.util.List;

public class Q216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int pos, int k, int target) {
        if (list.size() == k && target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i <= 9; i++) {
            list.add(i);
            dfs(result, list, i + 1, k, target - i);
            list.remove(list.size() - 1);
        }
    }

}
