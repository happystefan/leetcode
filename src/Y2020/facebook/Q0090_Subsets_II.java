package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0090_Subsets_II {

    class solution1_recursive {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rslt = new LinkedList<>();
            dfs(rslt, new LinkedList<>(), nums, 0);
            return rslt;
        }

        private void dfs(List<List<Integer>> rslt, List<Integer> list, int[] nums, int pos) {
            rslt.add(new LinkedList<>(list));
            for (int i = pos; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(rslt, list, nums, i + 1);
                list.remove(list.size() - 1);
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }
        }

    }


    class solution1_iterative {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> rslt = new LinkedList<>();
            rslt.add(new LinkedList<>());
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> tmp = new LinkedList<>(rslt);
                for (List<Integer> list : tmp) {
                    List<Integer> nlist = new LinkedList<>(list);
                    nlist.add(nums[i]);
                    rslt.add(nlist);
                }
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }
            return rslt;
        }

    }

}
