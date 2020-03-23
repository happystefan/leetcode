package Y2020.facebook;

public class Q0896_Monotonic_Array {

    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] > A[i + 1]) increasing = false;
            if (A[i] < A[i + 1]) decreasing = false;
        }
        return increasing || decreasing;
    }

}
