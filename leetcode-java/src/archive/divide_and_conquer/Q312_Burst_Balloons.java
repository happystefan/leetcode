package archive.divide_and_conquer;

public class Q312_Burst_Balloons {

    // D&V with memory: top down
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length+2];
        balloons[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            balloons[i+1] = nums[i];
        }
        balloons[balloons.length-1] = 1;
        int[][] memo = new int[balloons.length][balloons.length];
        return burst(balloons, 0, balloons.length-1, memo);
    }

    private int burst(int[] balloons, int l, int r, int[][] memo) {
        if (l+1 == r) {
            return 0;
        }
        if (memo[l][r] != 0) {
            return memo[l][r];
        }
        int result = 0;
        for (int i = l+1; i < r; i++) {
            result = Math.max(result, balloons[l]*balloons[i]*balloons[r]+
                    burst(balloons, l, i, memo)+
                    burst(balloons, i, r, memo));
        }
        memo[l][r] = result;
        return result;
    }

}
