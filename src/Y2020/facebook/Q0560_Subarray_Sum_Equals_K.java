package Y2020.facebook;

public class Q0560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 1;
        int count = 0;
        int sum = nums[left];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) count++;
        }
        while (left < nums.length - 1 && right < nums.length) {
            sum += nums[right];
            if (sum == k) count++;
            right++;
            if (right == nums.length) {
                left += 1;
                right = left + 1;
                sum = nums[left];
                continue;
            }
        }
        return count;
    }
    /*
    public int subarraySum(int[] nums, int k) {
        int i = 0, j = 0, sum = nums[0];
        int result = 0;
        while (j < nums.length) {
            if (sum > k) {
                sum -= nums[i++];
                if (i > j) {
                    sum += nums[j++];
                }
            } else if (sum < k) {
                sum += nums[j++];
            }
            if (sum == k) {
                result++;
            }
        }
        while (sum == k && i < nums.length) {
            sum -= nums[i++];
            result++;
        }
        return result;
    }

     */

    public static void main(String[] args) {
        Q0560_Subarray_Sum_Equals_K solution = new Q0560_Subarray_Sum_Equals_K();
        int result = solution.subarraySum(new int[]{1, 2, 3}, 3);
        System.out.println(result);
    }

}
