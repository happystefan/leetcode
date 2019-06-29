package Y2018.google;

public class Q050_Pow_x_n_B {

    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 1 ? x * pow(x * x, n / 2) : pow(x * x, n / 2);
    }

}
