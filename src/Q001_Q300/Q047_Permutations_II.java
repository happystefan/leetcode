package Q001_Q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mqliang on 6/4/17.
 */
public class Q047_Permutations_II {
    public class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] visit = new boolean[nums.length];
            dfs(ans, visit, new ArrayList<>(), nums);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, boolean[] visit, List<Integer> combs, int[] nums) {
            if (combs.size() == nums.length) {
                ans.add(new ArrayList<>(combs));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visit[i]) continue;
                visit[i] = true;
                combs.add(nums[i]);
                dfs(ans, visit, combs, nums);
                combs.remove(combs.size() - 1);
                visit[i] = false;
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }
        }
    }
}
