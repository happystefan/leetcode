package binary_search;

public class Q852_Peak_Index_in_a_Mountain_Array {

    // ternarySearch
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r - 1) {
            int m1 = l + (r - l) / 2;
            int m2 = m1 + (r - m1) / 2;
            if (A[m1] > A[m2]) {
                r = m2;
            } else {
                l = m1;
            }
        }
        return l;
    }

}

