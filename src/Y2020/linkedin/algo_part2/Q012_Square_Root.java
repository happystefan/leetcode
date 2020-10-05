package Y2020.linkedin.algo_part2;

public class Q012_Square_Root {

    public double mySqrt(double num) {
        double l = 0, r = num;
        double eps = 1e-6;
        while (r - l < eps) {
            double m = l + (r - l) / 2;
            if (m * m < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

}
