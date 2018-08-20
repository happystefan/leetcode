package archive.dp;

public class Q055_Jump_Game {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                return false;
            }
            for (int j = 0; j <= nums[i]; j++) {
                if (i+j < n) {
                    dp[i+j] = true;
                }
            }
        }
        return true;
    }

}
