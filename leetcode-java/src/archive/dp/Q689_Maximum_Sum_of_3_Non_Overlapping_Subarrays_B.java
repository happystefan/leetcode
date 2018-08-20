package archive.dp;

public class Q689_Maximum_Sum_of_3_Non_Overlapping_Subarrays_B {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        for (int i = 1; i+k <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i+k-1]- nums[i-1];
        }

        int[] result = new int[3];
        int max_sum = 0;
        for (int l = 0; l+2*k < sums.length; l++) {
            int m = l+k;
            for (int r = l+2*k; r < sums.length; r++) {
                if (sums[r-k] > sums[m]) m = r-k;
                if (sums[l]+sums[r]+sums[m] > max_sum) {
                    max_sum = sums[l]+sums[r]+sums[m];
                    result = new int[]{l, m, r};
                }
            }
        }
        return result;
    }

}
