package Q001_Q300;

import java.util.LinkedList;
import java.util.List;

public class Q228_Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        int i = 0, j = 0;
        while (i < nums.length) {
            while (j+1 < nums.length && nums[j+1] == nums[j]+1) j++;
            if (i == j) ans.add(String.valueOf(nums[i]));
            else ans.add(String.format("%d->%d", nums[i], nums[j]));
            j++;
            i = j;
        }
        return ans;
    }

}
