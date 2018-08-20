package archive.google;

public class Q050_Pow_x_n {

    public double myPow(double x, int n) {
        double ans = 1;
        long nn = n > 0 ? n : -(long)n; // caution: overflow
        while (nn > 0) {
            if (nn%2 == 1) ans *= x;
            x *= x;
            nn /= 2;
        }
        return n > 0 ? ans : 1/ans;
    }

}
