package Q001_Q300;

public class Q213_House_Robber_II {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int l, int h) {
        int include = 0, exclude = 0;
        for (int i = l; i <= h; i++) {
            int in = include, ex = exclude;
            include = exclude + nums[i];
            exclude = Math.max(ex, in);
        }
        return Math.max(include, exclude);
    }

}
