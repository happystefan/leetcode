package Y2019.Q0001_Q0300;

public class Q0050_Pow_x_n {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) return 1 / (myPow(x, Integer.MAX_VALUE) * x);
        if (n < 0) return 1 / myPow(x, -n);
        if (n == 0) return 1;
        if (n == 1) return x;
        return n % 2 == 1 ? myPow(x * x, n / 2) * x : myPow(x * x, n / 2);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public double myPow_iterative(double x, int n) {
        if (n == Integer.MIN_VALUE) return 1 / (myPow(x, Integer.MAX_VALUE) * x);
        if (n < 0) return 1 / myPow(x, -n);
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }

}
