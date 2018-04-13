package facebook;

public class Q141_Sqrt_x {

    public int sqrt(int x) {
        long l = 0, r = x/2;
        while (l <= r) {
            long m = l+(r-l)/2;
            if (m*m == (long)x) {
                return (int)m;
            } else if (m*m > (long)x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l*l > x ? (int)(l-1) : (int)l;
    }

}
