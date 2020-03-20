package Y2020.facebook;

public class Q0977_Squares_of_a_Sorted_Array {

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] rslt = new int[A.length];
        int i = rslt.length - 1;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            if (A[l] * A[l] > A[r] * A[r]) rslt[i--] = A[l] * A[l++];
            else rslt[i--] = A[r] * A[r--];
        }
        return rslt;
    }

}
