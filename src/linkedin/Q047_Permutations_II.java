package linkedin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q047_Permutations_II {

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] num, int[] visited) {
        if (list.size() == num.length) {
            result.add(list);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            List<Integer> next_list = new LinkedList<>(list);
            next_list.add(num[i]);
            visited[i] = 1;
            dfs(result, next_list, num, visited);
            visited[i] = 0;
            while (i + 1 < num.length && num[i + 1] == num[i]) {
                i++;
            }
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, visited);
        return result;
    }

}
