package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q065_Median_of_two_Sorted_Arrays_B {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length+B.length;
        return len%2 == 1
                ? findKth(A, 0, B, 0, len/2+1)
                : (findKth(A, 0, B, 0, len/2)+findKth(A, 0, B, 0, len/2+1))*0.5;
    }

    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){
        if (A_start >= A.length) return B[B_start+k-1];
        if (B_start >= B.length) return A[A_start+k-1];
        if (k == 1) return Math.min(A[A_start], B[B_start]);

        int A_key = A_start+k/2-1 < A.length ? A[A_start+k/2-1] : Integer.MAX_VALUE;
        int B_key = B_start+k/2-1 < B.length ? B[B_start+k/2-1] : Integer.MAX_VALUE;

        return A_key < B_key
                ? findKth(A, A_start+k/2, B, B_start, k-k/2)
                : findKth(A, A_start, B, B_start+k/2, k-k/2);
    }

}
