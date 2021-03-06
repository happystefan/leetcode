package Y2018.linkedin;

public class Q367_Valid_Perfect_Square {

    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m * m == num) {
                return true;
            }
            if (m * m < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
