package misc;

import java.util.*;

public class Q002_Encode_Consecutive_Num {
    /**
     * Given an array of integers, the array may contains some consecutive blocks.
     * Convert the array as a list of blocks (block was present as left_bound:right_bound),
     * unless the block only contains 1 element.
     *
     * Example:
     *
     * Given nums = [1, 2, 3, 5, 7, 8, 9], return ["1:3", "5", "7:9"].
     * */

    public List<String> encodeConsecutiveNum(int[] nums){
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        return encode(nums, 0, nums.length-1);
    }

    private List<String> encode(int[] nums, int l, int r) {
        List<String> result = new LinkedList<>();
        if (l > r) {
            return result;
        }
        if (l == r) {
            result.add(String.valueOf(nums[l]));
            return result;
        }
        if (nums[r]-nums[l] == r-l) {
            result.add(String.format("%d:%d", nums[l], nums[r]));
            return result;
        }
        int m = l + (r-l)/2;
        int ll = m, rr = m;
        while (ll-1 >= l && nums[ll-1] == nums[ll]-1) {
            ll--;
        }
        while (rr+1 <= r && nums[rr+1] == nums[rr]+1) {
            rr++;
        }
        List<String> lpart = encode(nums, l, ll-1);
        List<String> rpart = encode(nums, rr+1, r);
        result.addAll(lpart);
        result.add(ll == rr ? String.valueOf(nums[ll]) : String.format("%d:%d", nums[ll], nums[rr]));
        result.addAll(rpart);
        return result;
    }

}
