package archive.google;

import java.util.LinkedList;
import java.util.List;

public class Q228_Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j+1 < nums.length && nums[j+1] == nums[j]+1) j++;
            if (i == j) ans.add(String.format("%d", nums[i]));
            else ans.add(String.format("%d->%d", nums[i], nums[j]));
            i = j;
        }
        return ans;
    }

}
