package facebook;

public class Q062_Search_in_Rotated_Sorted_Array {

    public int search(int[] A, int target) {
        int l = 0, r = A.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (A[m] == target) {
                return m;
            }

            if (A[l] < A[m]) {
                if (A[l] <= target && target < A[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                if (A[m] < target && target <= A[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }

}
