package Y2020.facebook.bsearch;

import java.util.Arrays;

public class Q0410_Split_Array_Largest_Sum {

    class solution_bsearch {

        public int splitArray(int[] nums, int m) {
            int l = Arrays.stream(nums).max().getAsInt(), r = Arrays.stream(nums).sum();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (!isPossible(nums, m, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        private boolean isPossible(int[] nums, int m, int maxSum) {
            long sum = 0, cnt = 1;
            for (int num : nums) {
                sum += num;
                if (sum > maxSum) {
                    sum = num;
                    cnt++;
                    if (cnt > m) return false;
                }
            }
            return true;
        }

    }


    class solution_dfs {

        public int splitArray(int[] nums, int m) {
            int[] sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) sums[i + 1] = sums[i] + nums[i];
            int[][] memo = new int[nums.length][m + 1];
            return dfs(nums, sums, memo, m, 0);
        }

        private int dfs(int[] nums, int[] sums, int[][] memo, int m, int pos) {
            if (m == 1) return sums[nums.length] - sums[pos];
            if (memo[pos][m] != 0) return memo[pos][m];
            int rslt = Integer.MAX_VALUE;
            for (int i = pos + 1; i < nums.length; i++) {
                int l = sums[i] - sums[pos];
                int r = dfs(nums, sums, memo, m - 1, i);
                rslt = Math.min(rslt, Math.max(l, r));
            }
            memo[pos][m] = rslt;
            return rslt;
        }

    }

    class solution_dp {

        public int splitArray(int[] nums, int m) {
            int[] sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) sums[i + 1] = sums[i] + nums[i];
            int[][] dp = new int[nums.length + 1][m + 1];
            for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0][0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                    }
                }
            }
            return dp[nums.length][m];
        }

    }


}
