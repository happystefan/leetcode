package facebook;

import java.util.Arrays;
import java.util.List;

public class Q402_Continuous_Subarray_Sum {

    public List<Integer> continuousSubarraySum(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int ll = 0, rr = 0;

        for (int i = 1; i <= A.length; i++) {
            sum += A[i-1];

            if (sum > max) {
                max = sum;
                ll = l;
                rr = r;
            }

            if (sum < 0) {
                sum = 0;
                l = i;
            }
            r = i;
        }
        return Arrays.asList(ll, rr);
    }

}
