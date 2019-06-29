package Y2018.google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q368_Largest_Divisible_Subset_B {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        Arrays.sort(nums);
        List<Integer>[] lists = new List[nums.length];
        for (int i = 0; i < lists.length; i++) lists[i] = new LinkedList<>();
        int max = 1, idx = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && lists[i].size() < lists[j].size()) {
                    lists[i] = new LinkedList<>(lists[j]);
                }
            }
            lists[i].add(nums[i]);
            if (lists[i].size() > max) {
                max = lists[i].size();
                idx = i;
            }
        }
        return lists[idx];
    }

}
