package facebook;

public class Q428_Pow_x_n {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1/(x*myPow(x, -(n+1)));
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        return n%2 == 1 ? x*myPow(x*x, n/2) : myPow(x*x, n/2);
    }

}
