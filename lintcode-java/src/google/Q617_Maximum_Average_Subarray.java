package google;

/**
 * Created by mingqiangliang on 12/22/17.
 */
public class Q617_Maximum_Average_Subarray {

    public double maxAverage(int[] nums, int k) {
        // write your code here
        double[] sums = new double[nums.length+1];
        double lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        while (hi-lo > 1e-6) {
            double mid = (hi+lo)*0.5;
            double min = 0;
            for (int i = 1; i < k; i++) sums[i] = sums[i-1]+nums[i-1]-mid;
            boolean exist = false;
            for (int i = k; i <= nums.length; i++) {
                sums[i] = sums[i-1]+nums[i-1]-mid;
                if (sums[i] > min) {
                    exist = true;
                    break;
                }
                min = Math.min(min, sums[i-k+1]);
            }
            if (exist) lo = mid;
            else hi = mid;
        }
        return hi;
    }

}
