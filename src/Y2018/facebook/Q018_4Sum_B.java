package Y2018.facebook;

import java.util.*;

public class Q018_4Sum_B {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) r--;
                    if (sum < target) l++;
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }
        return new LinkedList<>(result);
    }

}
