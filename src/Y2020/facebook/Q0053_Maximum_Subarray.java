package Y2020.facebook;

public class Q0053_Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rslt = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            rslt = Math.max(rslt, sum);
            if (sum < 0) sum = 0;
        }
        return rslt;
    }

}
