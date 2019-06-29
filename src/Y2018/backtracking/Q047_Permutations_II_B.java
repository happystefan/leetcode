package Y2018.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q047_Permutations_II_B {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), map);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, Map<Integer, Integer> map) {
        if (map.size() == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int num : map.keySet()) {
            Map<Integer, Integer> tmp = new HashMap<>(map);
            tmp.put(num, tmp.get(num) - 1);
            if (tmp.get(num) == 0) {
                tmp.remove(num);
            }
            list.add(num);
            dfs(result, list, tmp);
            list.remove(list.size() - 1);
        }
    }

}
