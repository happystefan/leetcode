package Y2018.linkedin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q015_3sum_B {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                if (a + b + c < 0) {
                    l++;
                } else if (a + b + c > 0) {
                    r--;
                } else {
                    result.add(Arrays.asList(a, b, c));
                    while (l < r && nums[l] == b) l++;
                    while (l < r && nums[r] == c) r--;
                }
            }
            while (i < nums.length && nums[i] == a) i++;
        }
        return result;
    }

}
