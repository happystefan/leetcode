package google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q065_Median_of_two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] A, int[] B) {
        List<Integer> M = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] <= B[i]) M.add(A[i++]);
            else M.add(B[j++]);
        }
        while (i < A.length) M.add(A[i++]);
        while (j < B.length) M.add(A[j++]);
        return (A.length+B.length)%2 == 1
                ? M.get((A.length+B.length)/2)
                : (M.get((A.length+B.length)/2)+M.get((A.length+B.length)/2-1))*0.5;
    }

}
