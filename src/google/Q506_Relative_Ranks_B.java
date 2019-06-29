package google;

import java.util.Arrays;

public class Q506_Relative_Ranks_B {

    public String[] findRelativeRanks(int[] nums) {
        Integer[] rank = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) rank[i] = i;
        Arrays.sort(rank, (a, b) -> nums[b] - nums[a]);
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) ans[rank[i]] = "Gold Medal";
            else if (i == 1) ans[rank[i]] = "Silver Medal";
            else if (i == 2) ans[rank[i]] = "Bronze Medal";
            else ans[rank[i]] = String.valueOf(i + 1);
        }
        return ans;
    }

}
