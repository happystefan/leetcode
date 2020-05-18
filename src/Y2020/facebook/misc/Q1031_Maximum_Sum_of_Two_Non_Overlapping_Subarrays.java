package Y2020.facebook.misc;

public class Q1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) sums[i + 1] = sums[i] + A[i];
        int rslt = sums[L + M], Lmax = sums[L], Mmax = sums[M];
        for (int i = L + M + 1; i < sums.length; i++) {
            Lmax = Math.max(Lmax, sums[i - M] - sums[i - M - L]);
            Mmax = Math.max(Mmax, sums[i - L] - sums[i - M - L]);
            rslt = Math.max(rslt, Math.max(Lmax + sums[i] - sums[i - M], Mmax + sums[i] - sums[i - L]));
        }
        return rslt;
    }

}
