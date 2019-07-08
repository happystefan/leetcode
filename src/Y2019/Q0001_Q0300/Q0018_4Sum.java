package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0018_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; ) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; ) {
                int b = nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int c = nums[l], d = nums[r];
                    int sum = a + b + c + d;
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        result.add(Arrays.asList(a, b, c, d));
                        while (l < r && nums[l] == c) l++;
                        while (l < r && nums[r] == d) r--;
                    }
                }
                while (j < nums.length && nums[j] == b) j++;
            }
            while (i < nums.length && nums[i] == a) i++;
        }
        return result;
    }

}
