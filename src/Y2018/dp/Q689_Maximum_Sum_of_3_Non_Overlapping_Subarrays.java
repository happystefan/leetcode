package Y2018.dp;

import java.util.LinkedList;
import java.util.List;

public class Q689_Maximum_Sum_of_3_Non_Overlapping_Subarrays {
    // DFS: Time Limit Exceeded
    int max_sum = Integer.MIN_VALUE;
    List<Integer> result;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        for (int i = 1; i + k <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i + k - 1] - nums[i - 1];
        }
        dfs(sums, new LinkedList<>(), 0, 0, k);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int[] nums, List<Integer> list, int pos, int sum, int k) {
        if (list.size() == 3) {
            if (sum > max_sum) {
                max_sum = sum;
                result = new LinkedList<>(list);
            }
            return;
        }
        if (pos >= nums.length) {
            return;
        }
        list.add(pos);
        dfs(nums, list, pos + k, sum + nums[pos], k);
        list.remove(list.size() - 1);
        dfs(nums, list, pos + 1, sum, k);
    }

}
