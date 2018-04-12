package facebook;

public class Q064_Merge_Sorted_Array {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int k = m+n;
        while (m > 0 && n > 0) {
            if (A[m-1] > B[n-1]) {
                A[--k] = A[--m];
            } else {
                A[--k] = B[--n];
            }
        }
        while (m > 0) {
            A[--k] = A[--m];
        }
        while (n > 0) {
            A[--k] = B[--n];
        }
    }

}
