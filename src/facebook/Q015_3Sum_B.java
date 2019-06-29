package facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q015_3Sum_B {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                if (a + b + c == 0) {
                    result.add(Arrays.asList(a, b, c));
                    while (l < r && nums[l] == b) l++;
                    while (l < r && nums[r] == c) r--;
                } else if (a + b + c < 0) {
                    l++;
                } else if (a + b + c > 0) {
                    r--;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == a) i++;
        }
        return result;
    }

}
