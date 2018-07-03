package Q001_Q300;

public class Q198_House_Robber {

    public int rob(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) a = Math.max(a, b+nums[i]);
            else b = Math.max(b, a+nums[i]);
        }
        return Math.max(a, b);
    }

}
