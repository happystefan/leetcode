package Y2018.facebook.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        dfs(result, new LinkedList<>(), set);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, Set<Integer> set) {
        if (set.isEmpty()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int num : set) {
            Set<Integer> tmp = new HashSet<>(set);
            tmp.remove(num);
            list.add(num);
            dfs(result, list, tmp);
            list.remove(list.size() - 1);
        }
    }

}
