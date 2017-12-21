package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q075_Find_Peak_Element {

    public int findPeak(int[] A) {
        int lo = 0, hi = A.length-1;
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (A[mid] < A[mid+1]) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }

}
