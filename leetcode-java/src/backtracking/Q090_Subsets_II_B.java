package backtracking;

import java.util.*;

public class Q090_Subsets_II_B {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new LinkedList<>());
        int size = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = i >= 1 && nums[i] == nums[i-1] ? size: 0;
            size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> tmp = new LinkedList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }

}
