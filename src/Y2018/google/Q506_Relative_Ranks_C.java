package Y2018.google;

public class Q506_Relative_Ranks_C {

    public String[] findRelativeRanks(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) bucket[nums[i]] = i;
        String[] ans = new String[nums.length];
        int k = 1;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == 0) continue;
            if (k == 1) ans[bucket[i]] = "Gold Medal";
            else if (k == 2) ans[bucket[i]] = "Silver Medal";
            else if (k == 3) ans[bucket[i]] = "Bronze Medal";
            else ans[bucket[i]] = String.valueOf(k);
            k++;
        }
        return ans;
    }

}
