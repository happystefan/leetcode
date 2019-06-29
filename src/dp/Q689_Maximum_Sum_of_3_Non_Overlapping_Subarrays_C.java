package dp;

import java.util.Arrays;

public class Q689_Maximum_Sum_of_3_Non_Overlapping_Subarrays_C {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        for (int i = 1; i + k <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i + k - 1] - nums[i - 1];
        }

        System.out.println(Arrays.toString(sums));
        System.out.println();

        int[][] dp = new int[4][sums.length + 1];
        int[][] id = new int[4][sums.length + 1];

        /*
        archive.dp[0][0] = sums[0];
        id[0][0] = 0;
        for (int j = 1; j < k; j++) {
            if (archive.dp[0][j-1] > sums[j]) {
                archive.dp[0][j] = archive.dp[0][j-1];
                id[0][j] = id[0][j-1];
            } else {
                archive.dp[0][j] = sums[j];
                id[0][j] = j;
            }
        }
        */

        for (int i = 1; i <= 3; i++) {
            for (int j = k; j < sums.length; j++) {

                /*
                archive.dp[i][j] = Math.max(archive.dp[i-1][j-1], archive.dp[i-1][j-k]+sums[j]);
                */
                if (dp[i - 1][j - k] + sums[j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j - k] + sums[j];
                    id[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    id[i][j] = id[i][j - 1];
                }


            }
            System.out.println(Arrays.toString(dp[i]));
            System.out.println(Arrays.toString(id[i]));
        }
        int[] result = new int[3];
        result[2] = id[3][sums.length - 1];
        result[1] = id[2][result[2]];
        result[0] = id[1][result[1]];
        return result;
    }

}
