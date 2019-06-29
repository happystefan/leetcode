package Y2018.facebook;

import java.util.Arrays;

public class Q801_Minimum_Swaps_To_Make_Sequences_Increasing_B {

    public int minSwap(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] keep = new int[n];
        int[] swap = new int[n];
        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                keep[i] = Math.min(keep[i], keep[i - 1]);
                swap[i] = Math.min(swap[i], swap[i - 1] + 1);
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                keep[i] = Math.min(keep[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
            }
        }
        return Math.min(keep[n - 1], swap[n - 1]);
    }

}
