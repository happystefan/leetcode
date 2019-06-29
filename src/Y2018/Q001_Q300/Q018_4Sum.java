package Y2018.Q001_Q300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mqliang on 5/30/17.
 */
public class Q018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int c = nums[l], d = nums[r];
                    int sum = a + b + c + d;
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else if (sum == target) {
                        ans.add(Arrays.asList(a, b, c, d));
                        while (l < r && nums[l] == c) l++;
                        while (l < r && nums[r] == d) r--;
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == b) j++;
            }
            while (i + 1 < nums.length && nums[i + 1] == a) i++;
        }
        return ans;
    }
}
