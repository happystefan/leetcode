package google;

/**
 * Created by mingqiangliang on 12/25/17.
 */
public class Q724_Minimum_Partition {

    public int findMin(int[] arr) {
        // write your code here
        int sum = 0;
        for (int num : arr) sum += num;

        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;

        for (int num : arr) {
            for (int i = sum/2; i >= num; i--) {
                dp[i] |= dp[i-num];
            }
        }

        int i;
        for (i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                break;
            }
        }

        return sum - 2*i;

    }

}
