package Y2020.facebook;

public class Q0643_Maximum_Average_Subarray_I {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double rslt = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            rslt = Math.max(rslt, sum);
        }
        return rslt * 1.0 / k;
    }

}
