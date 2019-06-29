package facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q018_4Sum_C {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int c = nums[l], d = nums[r];
                    if (a + b + c + d > target) r--;
                    if (a + b + c + d < target) l++;
                    if (a + b + c + d == target) {
                        result.add(Arrays.asList(a, b, c, d));
                        while (l < r && nums[l] == c) l++;
                        while (l < r && nums[r] == d) r--;
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == b) j++;
            }
            while (i + 1 < nums.length && nums[i + 1] == a) i++;
        }
        return result;
    }

}
