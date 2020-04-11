package Y2020.facebook;

public class Q0055_Jump_Game {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) dp[i + j] |= dp[i];
        }
        return dp[nums.length - 1];
    }

}
