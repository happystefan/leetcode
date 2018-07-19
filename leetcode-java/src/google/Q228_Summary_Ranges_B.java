package google;

import java.util.*;

public class Q228_Summary_Ranges_B {

    public List<String> summaryRanges(int[] nums) {
        return summary(nums, 0, nums.length-1);
    }

    public List<String> summary(int[] nums, int l, int r) {
        List<String> result = new LinkedList<>();
        if (l > r) {
            return result;
        }
        if (l == r) {
            result.add(String.valueOf(nums[l]));
            return result;
        }
        if (r-l == nums[r]-nums[l]) {
            result.add(String.format("%d->%d", nums[l], nums[r]));
            return result;
        }
        int m = l+(r-l)/2;
        int i = m, j = m;
        while (i-1 >= l && nums[i-1] == nums[i]-1) {
            i--;
        }
        while (j+1 <= r && nums[j+1] == nums[j]+1) {
            j++;
        }
        List<String> lpart = summary(nums, l, i-1);
        List<String> rpart = summary(nums, j+1, r);
        result.addAll(lpart);
        result.add(i == j ? String.valueOf(nums[i]) : String.format("%d->%d", nums[i], nums[j]));
        result.addAll(rpart);
        return result;
    }

}
