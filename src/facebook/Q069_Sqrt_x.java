package facebook;

public class Q069_Sqrt_x {

    public int mySqrt(int x) {
        long l = 0, r = (long) x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m * m == x) {
                return (int) m;
            }
            if (m * m > x) {
                r = m - 1;
            } else {
                if ((m + 1) * (m + 1) > x) {
                    return (int) m;
                }
                l = m + 1;
            }
        }
        return (int) l;
    }

}
