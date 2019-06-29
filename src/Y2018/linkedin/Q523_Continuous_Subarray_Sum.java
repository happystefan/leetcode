package Y2018.linkedin;

public class Q523_Continuous_Subarray_Sum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < sums.length; i++) {
            for (int l = 2; i + l < sums.length; l++) {
                int sum = sums[i + l] - sums[i];
                if (k == 0 && sum == 0 || k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
