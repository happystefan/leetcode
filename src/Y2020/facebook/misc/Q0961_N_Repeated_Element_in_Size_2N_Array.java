package Y2020.facebook.misc;

public class Q0961_N_Repeated_Element_in_Size_2N_Array {

    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) return A[i];
        }
        return A[0];
    }

}
