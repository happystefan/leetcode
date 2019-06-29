package Y2018.google;

public class Q560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) ans++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

}
