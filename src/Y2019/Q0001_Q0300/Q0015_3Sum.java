package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0015_3Sum {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 1:
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> threeSum_v1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                if (a + b + c < 0) l++;
                else if (a + b + c > 0) r--;
                else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == b) l++;
                    while (l < r && nums[r] == c) r--;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == a) i++;
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 2:
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> threeSum_v2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; /*NOTES: take care here */) {
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                if (a + b + c < 0) l++;
                else if (a + b + c > 0) r--;
                else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == b) l++;
                    while (l < r && nums[r] == c) r--;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == a) i++;
        }
        return result;
    }

}
