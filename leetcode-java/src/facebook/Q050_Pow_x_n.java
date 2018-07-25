package facebook;

public class Q050_Pow_x_n {

    public double myPow(double x, int n) {
        if (n < 0) {
            return pow(1.0/x, -(long)n);
        }
        return pow(x, n);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        return pow(x*x, n/2)*pow(x, n%2);
    }

}
