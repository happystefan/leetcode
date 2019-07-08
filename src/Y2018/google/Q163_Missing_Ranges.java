package Y2018.google;

import java.util.LinkedList;
import java.util.List;

public class Q163_Missing_Ranges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long llower = (long) lower - 1;
        long lupper = (long) upper + 1;
        long[] new_nums = new long[nums.length + 2];
        int k = 0;
        new_nums[k++] = llower;
        for (int num : nums) {
            if (new_nums[k - 1] != num) new_nums[k++] = num;
        }
        if (new_nums[k - 1] != lupper) new_nums[k++] = lupper;
        return find(new_nums, 0, k - 1);
    }

    private List<String> find(long[] nums, int l, int r) {
        List<String> result = new LinkedList<>();
        if (l > r) {
            return result;
        }
        if (r - l == nums[r] - nums[l]) {
            return result;
        }
        if (r - l == 1 && nums[r] != nums[l] + 1) {
            result.add(nums[r] - 1 == nums[l] + 1 ? String.valueOf(nums[l] + 1) : String.format("%d->%d", nums[l] + 1, nums[r] - 1));
            return result;
        }
        int m = l + (r - l) / 2;
        int i = m, j = m;
        while (i - 1 >= l && nums[i - 1] == nums[i] - 1) i--;
        while (j + 1 <= r && nums[j + 1] == nums[j] + 1) j++;
        List<String> lpart = find(nums, l, i);
        List<String> rpart = find(nums, j, r);
        result.addAll(lpart);
        result.addAll(rpart);
        return result;
    }

}

