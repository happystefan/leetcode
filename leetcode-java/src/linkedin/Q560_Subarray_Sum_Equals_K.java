package linkedin;

public class Q560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                result++;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]-nums[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

}
