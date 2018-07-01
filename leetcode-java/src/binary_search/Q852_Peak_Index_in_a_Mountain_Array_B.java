package binary_search;

public class Q852_Peak_Index_in_a_Mountain_Array_B {

    // BinarySearch
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (A[m] < A[m+1]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

}
