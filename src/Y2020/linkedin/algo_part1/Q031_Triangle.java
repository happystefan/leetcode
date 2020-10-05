package Y2020.linkedin.algo_part1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q031_Triangle {

    // NOTE: negative integer test case
    public int[] getTriangleSide(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        Arrays.sort(nums);
        /*
         *
         * Assume A, B, C is triangle and A < B < C
         * And there exist A' and B' such that A < A' < B < C' < C
         * Then:
         * A' + B > A + B > C > C'
         * A' + C' > B
         * B + C' > A'
         * Thus, A' B C' is also a triangle. In other words, there if there are any triangle exist
         * for the given nums, then there must exist a triplet which is consecutive can also form
         * a triangle
         *
         * */
        for (int i = 0; i + 2 < nums.length; i++) {
            if (isTriangle(nums[i], nums[i + 1], nums[i + 2])) {
                return new int[]{nums[i], nums[i + 1], nums[i + 2]};
            }
        }
        return null;
    }

    private boolean isTriangle(int a, int b, int c) {
        /*
         * caution: integer overflow problem. May use a - b < c to do the check
         *
         */
        return a + b > c && a + c > b && b + c > a;
    }

    // O(N^2) since K is monotonous increasing -- we do not reinitialize the value of k
    // for a new value of j chosen (for the same i)
    public List<int[]> allTriangles(int[] nums) {
        List<int[]> rslt = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length; j++) {
                while (k < nums.length && isTriangle(nums[i], nums[j], nums[k])) {
                    rslt.add(new int[]{nums[i], nums[j], nums[k]});
                    k++;
                    // only need this if we want deduplicate
                    while (k + 1 < nums.length && nums[k + 1] == nums[k]) k++;
                }
                // only need this if we want deduplicate
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
            }
            // only need this if we want deduplicate
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
        return rslt;
    }


}
